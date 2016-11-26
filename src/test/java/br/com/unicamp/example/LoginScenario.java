package br.com.unicamp.example;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.assertj.core.internal.cglib.core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginScenario extends BaseScenario {

	@Given("^user is not logged in$")
	public void user_is_not_logged_in() throws Throwable {
		try {
			WebElement element = driver.findElement(By.id(Contants.ID_LOGOUT));
			element.click();
		} catch (org.openqa.selenium.NoSuchElementException ignored) {
		}
	}

	@When("^I open the Sade page$")
	public void I_open_the_sade_page() throws Throwable {
		driver.get(Contants.SADE_URL);
	}

	@Then("^a browser should display the login page containing \"([^\"]*)\"$")
	public void a_browser_should_display_the_login_page(String text) throws Throwable {
		WebElement element = driver.findElement(By.id("welcome"));

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(element));
		assertThat(element.getText().contains(text));
	}

	@When("^I fill developer credentials and submit$")
	public void i_fill_developer_credentials_and_submit() throws Throwable {
		login(Contants.DEVELOPER_LOGIN, Contants.DEVELOPER_PASSWORD);
	}

	@When("^I fill administrator credentials and submit$")
	public void i_fill_administrator_credentials_and_submit() throws Throwable {
		login(Contants.ADMIN_LOGIN, Contants.ADMIN_PASSWORD);
	}

	@When("^I fill invalid credentials and submit$")
	public void i_fill_invalid_credentials_and_submit() throws Throwable {
		login(Contants.INVALID_LOGIN, Contants.INVALID_PASSWORD);
	}

	private void login(String username, String password){
		if(!driver.findElement(By.id("menuLogin")).getAttribute("class").contains("open")) {
			driver.findElement(By.id(Contants.ID_MENU_LOGIN)).click();
		}
		WebElement loginForm = driver.findElement(By.id(Contants.ID_FORM_LOGIN));
		WebElement usernameInput = loginForm.findElement(By.name(Contants.NAME_INPUT_LOGIN_USERNAME));
		usernameInput.clear();
		usernameInput.sendKeys(username);
		WebElement passwordInput = loginForm.findElement(By.name(Contants.NAME_INPUT_LOGIN_PASSWORD));
		passwordInput.clear();
		passwordInput.sendKeys(password);
		loginForm.findElement(By.id(Contants.ID_FORM_LOGIN_SUBMIT)).click();
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^a browser should display the main page of developers$")
	public void aBrowserShouldDisplayTheMainPageOfDevelopers() throws Throwable {
		waitForPageLoad();
		assertThat(driver.getCurrentUrl()).isEqualToIgnoringCase(Contants.DEVELOPER_HOME_URL);
	}

	@Then("^a browser should display the main page of administrators$")
	public void aBrowserShouldDisplayTheMainPageOfAdministrators() throws Throwable {
		waitForPageLoad();
		assertThat(driver.getCurrentUrl()).isEqualToIgnoringCase(Contants.ADMIN_HOME_URL);
	}

	@Then("^a browser should display an error message \"([^\"]*)\"$")
	public void aBrowserShouldDisplayAnErrorMessage(String arg0) throws Throwable {
		assertThat(driver.findElement(By.id(Contants.ID_ERROR_MESSAGE)).getText()).contains(arg0);
	}

	@Given("^user is logged in as an developer$")
	public void userIsLoggedInAsAnDeveloper() throws Throwable {
		try {
			WebElement element = driver.findElement(By.id(Contants.ID_USER_TYPE));
			if (!element.getText().contains("Desenvolvedor")){
				user_is_not_logged_in();
				i_fill_developer_credentials_and_submit();
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			i_fill_developer_credentials_and_submit();
		}
	}

	@Given("^user is logged in as an administrator")
	public void userIsLoggedInAsAnAdministrator() throws Throwable {
		try {
			WebElement element = driver.findElement(By.id(Contants.ID_USER_TYPE));
			if (!element.getText().contains("Administrador")){
				user_is_not_logged_in();
				i_fill_administrator_credentials_and_submit();
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			i_fill_administrator_credentials_and_submit();
		}
	}

}
