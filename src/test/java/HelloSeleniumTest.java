import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {

    @Test
    public void firstTest() throws InterruptedException {
        //Telling the system where to find chromedriver
        System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
        driver.quit();
    }
}
