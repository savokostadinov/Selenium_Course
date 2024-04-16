package best.practices;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.sql.DriverManager.getDriver;

public class Syncronization {
    WebDriver driver;
    String elementExistInDOM = "https://the-internet.herokuapp.com/dynamic_loading/1";
    String elementRenderedAfter = "https://the-internet.herokuapp.com/dynamic_loading/2";

    By locator = By.id("finish");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void implicitWaitFindsHiddenElement(){
        driver.get(elementExistInDOM);
        driver.findElement(locator);
    }

    @Test
    public void implicitWaitThrowsNoSuchElementException(){
        driver.get(elementRenderedAfter);
        driver.findElement(locator);
    }

    @Test
    public void configuredImplicitWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(elementRenderedAfter);
        driver.findElement(locator);
    }

    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void explicitWaitFixesImplicitWaitIssues(){
        driver.get(elementExistInDOM);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Test
    public void explicitWaitWhenElementPresent(){
       driver.get(elementExistInDOM);
       WebDriverWait wait = new WebDriverWait(driver, 5);
       wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

//    @Test
//    public void correctSyncronization(){
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement startbutton =
//
//    }
    @Test
    public void exercise1Wait(){
        driver.get("https://webdriveruniversity.com/Ajax-Loader/index.html");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("button1"))));
        Assert.assertTrue(driver.findElement(By.id("button1")).isDisplayed());
    }

}




























