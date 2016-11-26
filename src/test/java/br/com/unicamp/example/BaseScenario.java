package br.com.unicamp.example;

import cucumber.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * Created by ra139223 on 11/25/16.
 */
public class BaseScenario {

    static WebDriver driver;

    void fillInputByName(String name, String value){
        fillInputBy(By.name(name), value);
    }

    void fillInputByClassName(String className, String value){
        fillInputBy(By.className(className), value);
    }

    void fillInputById(String id, String value){
        fillInputBy(By.id(id), value);
    }

    void fillInputBy(By by, String value){
        WebElement el = driver.findElement(by);
        el.clear();
        el.sendKeys(value);
    }

    @Before
    public void setUp() throws IOException {
        if(driver == null) {
            File classpathRoot = new File(System.getProperty("user.dir"));
            File chromedriver = new File(classpathRoot, "driver/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
            driver = new ChromeDriver();
        }
    }

    void waitForPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Contants.ID_FOOTER)));
    }
}
