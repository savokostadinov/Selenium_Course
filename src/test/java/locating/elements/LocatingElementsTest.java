package locating.elements;

import jdk.jfr.Timespan;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LocatingElementsTest {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void elementsQuiz1() throws InterruptedException {
        //Telling the system where to find chromedriver.
        //System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");

        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element //4. check the state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        Thread.sleep(5000);
        // 5. take action //6. record the result
        Assert.assertTrue(element.isDisplayed());
        //7. quit the driver
        //driver.quit();
    }

    @Test
    public void typesOfLocators(){
        //Telling the system where to find chromedriver.
        //System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");

        //1. Instantiate the driver
        //WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element
        WebElement element;
        //ID
        element = driver.findElement(By.id("user-name"));
        //Name
        element = driver.findElement(By.name("user-name"));
        //Class name
        element = driver.findElement(By.className("form_input"));
        //Tag name
        element = driver.findElement(By.tagName("input"));
        //Css selector
        element = driver.findElement(By.cssSelector("#user-name"));
        //Xpath
        element = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        //Link text
       // element = driver.findElement(By.partialLinkText("link text!"));
        //Partial link text
        //driver.quit();
    }

    @Test
    public void locatorExam() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(Timespan.SECONDS("seconds"));
        driver.get("https://www.saucedemo.com/");

        //Use CSS selectors
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(2000);

        //Use CSS/Xpath
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        Thread.sleep(2000);

        //Use the best locator
        driver.findElement(By.id("first-name")).sendKeys("first name");
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys("last name");
        Thread.sleep(2000);
        driver.findElement(By.id("postal-code")).sendKeys("zip");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);

        //By link text
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("#checkout_complete_container")).isDisplayed());

    }

    @Test
    public void exercise1(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'no id')]/following-sibling::table//td[contains(text(),'$120,000+')]")).isDisplayed());
    }
    @Test
    public void exercise2(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        Assert.assertTrue(driver.findElement(By.xpath
                        ("//table[@id='htmlTableId']//td[text()='Automation Testing Architect']//following-sibling::td[2]"))
                .getText()
                .equals("$120,000+"));
    }
    @Test
    public void exercise3(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Click Me!']/ancestor::form/preceding-sibling::h3"))
                .getText()
                .contains("Feel free to practice your test automation on these elements"));
    }

    @Test
    public void exercise4(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        Assert.assertTrue(driver.findElement(By.xpath("//table[@id='htmlTableId']//tr[last()]/td[1]")).getText().equals("Quality Assurance Engineer"));
    }


}




















