package web.driver.methods;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverMethodsExam {

    WebDriver driver;
    WebElement element;
    private JavascriptExecutor javascriptExecutor;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        javascriptExecutor = ((JavascriptExecutor) driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    // open url https://example.cypress.io/commands/actions
    // Focus on element By.cssSelector(".action-focus")
    // Assert is focused

    @Test
    public void actions() {
        driver.get("https://example.cypress.io/commands/actions");
        element = driver.findElement(By.cssSelector(".action-focus"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@for='password1']")).getAttribute("style").contains("color:orange;"));
    }

    // navigate to https://example.cypress.io/commands/cookies
    // set a cookie using button
    // get the cookie named token
    // asset that we have a cookie value equal to "123ABC"

    @Test
    public void cookies(){
        driver.get("https://example.cypress.io/commands/cookies");
        element = driver.findElement(By.cssSelector("#getCookie .set-a-cookie"));
        element.click();

        var cookie = driver.manage().getCookieNamed("token");
        Assert.assertEquals("123ABC", cookie.getValue());
    }

    // navigate to https://ultimateqa.com/complicated-page/
    // scroll to bottom of page using js execute Script command:
    // window.scrollTo(0, document.body.scrollHeight)
    // Thread.sleep(100)0

    @Test
    public void scrolltoBottom() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    @Test
    public void scrollToTop() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(2000);
    }







}
