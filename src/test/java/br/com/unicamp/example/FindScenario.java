package br.com.unicamp.example;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.com.unicamp.example.RegisterScenario.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class FindScenario extends BaseScenario {

    @And("^the search page of developers is opened$")
    public void the_search_page_of_developers_is_opened() throws Throwable {
        driver.get(Contants.SEARCH_URL);
        waitForPageLoad();
        assertThat(driver.getCurrentUrl()).isEqualToIgnoringCase(Contants.ADMIN_HOME_URL);
    }

    @When("^I fill the name box with a developer name$")
    public void iFillTheNameBoxWithADeveloperName() throws Throwable {
        waitForPageLoad();
        fillInputById("buscaNome", Contants.DEVELOPER_NAME);
    }

    @And("^submit the search form$")
    public void submitTheSearchForm() throws Throwable {
        waitForPageLoad();
        driver.findElement(By.id("submit-search")).click();
    }

    @When("^I fill the name box with a unregistered developer name$")
    public void iFillTheNameBoxWithAUnregisteredDeveloperName() throws Throwable {
        waitForPageLoad();
        fillInputById("buscaNome", Contants.DEVELOPER_NAME_INVALID);
    }

    @Then("^a browser should display all developers with the same name$")
    public void aBrowserShouldDisplayAllDevelopersWithTheSameName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I select some language check boxes$")
    public void iSelectSomeLanguageCheckBoxes() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The browser should display all developers with all languages selected$")
    public void theBrowserShouldDisplayAllDevelopersWithAllLanguagesSelected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
