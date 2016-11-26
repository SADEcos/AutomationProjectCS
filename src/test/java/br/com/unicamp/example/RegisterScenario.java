package br.com.unicamp.example;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterScenario extends BaseScenario {
	@After
	public void tearDown(){
		//		driver.close();
	}


	@When("^I click on sign up link$")
	public void iClickOnSignUpLink() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSignUp")));
		WebElement element = driver.findElement(By.id("btnSignUp"));
		element.click();
	}

	@Then("^The browser should display the sign up form$")
	public void theBrowserShouldDisplayTheSignUpForm() throws Throwable {
		assertThat(driver.getCurrentUrl().contains("/#/cadastro"));
	}

	@Given("^the sign up form is opened$")
	public void theSignUpFormIsOpened() throws Throwable {
		assertThat(driver.getCurrentUrl().contains("/#/cadastro"));
	}

	@When("^I fill the sign up form with correct information$")
	public void iFillTheSignUpFormWithCorrectInformation() throws Throwable {
		HashMap<String, String> map = new HashMap<String, String>(){
			{
				put("nome", "Vinicius");
				put("email", "a@a.com");
				put("senha", "123456");
				put("senha2", "123456");
				put("cpf", "12345678914");
				put("rg", "124587458");
				put("instituicao", "Unicamp");
				put("curso", "Engenharia de Computacao");
				put("disponibilidade", "20");
				put("graduacao", "20");
				put("estagio", "0");
				put("celular", "11123455569");
				put("telefone", "1122547895");
				put("endereco", "Rua Outro Nome, 174");
				put("conpec", "Palestra dos bixos");
			}
		};

		(new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.id("telefone")));
		for (Map.Entry<String, String> item : map.entrySet()){
//			System.out.println(item.getKey());
			WebElement input = driver.findElement(By.id(item.getKey()));
			input.clear();
			input.sendKeys(item.getValue());
		}

		Thread.sleep(1*1000);
	}

	@And("^submit the sign up form$")
	public void submitTheSignUpForm() throws Throwable {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
		driver.findElement(By.name("submit")).click();
	}

	@And("^submit the skills form$")
	public void submitTheSkillsForm() throws Throwable {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("submitSkills")));
		driver.findElement(By.id("submitSkills")).click();
	}

	@Then("^The browser should display the skills page$")
	public void theBrowserShouldDisplayTheMainPageOfDevelopers() throws Throwable {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("rzslider")));
		assertThat(driver.findElement(By.className("rzslider")) != null);

	}

	@Then("^The browser should display the success page with message \"([^\"]*)\"$")
	public void theBrowserShouldDisplayTheSuccessPage(String message) throws Throwable {
		waitForPageLoad();
		assertThat(driver.getCurrentUrl()).isEqualToIgnoringCase(Contants.SUCCESS_URL);
		assertThat(driver.findElement(By.className("alert-success")).getText().contains(message));
	}
}
