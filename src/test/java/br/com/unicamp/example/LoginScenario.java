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

public class LoginScenario  {
	
    protected WebDriver driver;

    @Before
    public void setUp() throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File chromedriver = new File(classpathRoot, "driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.close();
    }
	

	@Given("^user is not logged in$")
	public void user_is_not_logged_in() throws Throwable {
		//Nothing To-Do
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



}
