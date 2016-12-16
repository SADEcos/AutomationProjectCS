package br.com.unicamp.example;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static br.com.unicamp.example.Contants.DEVELOPER_NAME;
import static br.com.unicamp.example.RegisterScenario.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class FindScenario extends BaseScenario {

    @And("^the search page of developers is opened$")
    public void the_search_page_of_developers_is_opened() throws Throwable {
        if(driver.getCurrentUrl().equals(Contants.SEARCH_URL))
            return;
        driver.get(Contants.SEARCH_URL);
        waitForPageLoad();
        assertThat(driver.getCurrentUrl()).isEqualToIgnoringCase(Contants.ADMIN_HOME_URL);
    }

    @When("^I fill the name box with a developer name$")
    public void iFillTheNameBoxWithADeveloperName() throws Throwable {
        waitForPageLoad();
        fillInputById("buscaNome", DEVELOPER_NAME);
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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> devs = driver.findElements(By.className("linhaDev"));
        for (WebElement dev : devs) {
            assertThat(dev.findElements(By.tagName("td")).get(0).getText().toLowerCase()).contains(DEVELOPER_NAME.toLowerCase());
        }
    }

    @Then("^a browser should display (\\d+) developers$")
    public void aBrowserShouldDisplayDevelopers(int numDevs) throws Throwable {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        assertThat(driver.findElements(By.className("linhaDev")).size()).isEqualTo(numDevs);
    }

    @When("^I click the language checkbox \"([^\"]*)\"$")
    public void iSelectALanguageCheckbox(String language) throws Throwable {
        waitForPageLoad();
        driver.findElement(By.id(language)).click();
    }

    @Then("^The browser should display the language column \"([^\"]*)\"$")
    public void theBrowserShouldDisplayTheLanguageColumn(String arg0) throws Throwable {
        assertThat(isColumnShown(arg0)).isTrue();
    }

    private Boolean isColumnShown(String column){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> colunas = driver.findElements(By.className("colunaDev"));
        for (WebElement coluna : colunas) {
            if (coluna.getText().toLowerCase().contains(column.toLowerCase()) && coluna.isDisplayed())
                return true;
        }
        return false;
    }

    @Then("^The browser should not display the language column \"([^\"]*)\"$")
    public void theBrowserShouldNotDisplayTheLanguageColumn(String arg0) throws Throwable {
        assertThat(isColumnShown(arg0)).isFalse();
    }

    @When("^I click the first developer$")
    public void iClickTheFirstDeveloper() throws Throwable {
        driver.findElements(By.className("linhaDev")).get(0).findElement(By.tagName("a")).click();
    }

    @Then("^a browser should display the page of the developer")
    public void aBrowserShouldDisplayTheMainPageOfDevelopers() throws Throwable {
        waitForPageLoad();
        assertThat(driver.getCurrentUrl()).contains(Contants.DEVELOPER_HOME_URL);
    }

    @Then("^a browser should display a modal with the developer information$")
    public void aBrowserShouldDisplayAModalWithTheDeveloperInformation() throws Throwable {
        waitForPageLoad();
        Thread.sleep(2000);
        assertThat(driver.findElement(By.id("modal-dev-info")).isDisplayed()).isEqualTo(true);
    }
}
