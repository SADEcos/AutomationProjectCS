package br.com.unicamp.example;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public abstract class BaseScenario {

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

    void waitForPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Contants.ID_FOOTER)));
    }
}
