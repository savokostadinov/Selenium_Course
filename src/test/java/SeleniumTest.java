import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {

    // Navigate to this URL using another browser https://the-internet.herokuapp.com/
    // Navigate to this URL http://example.cypress.io/
    // Navigate to http://react-shopping-cart-67954.firebaseapp.com/
    // Using WebDriverManager


    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass(){
        WebDriverManager.edgedriver().setup();
    }

    @Test
    public void runTestsInOrder() throws InterruptedException {
        edgeTest();
        cypressTest();
        reactShoppingCartTest();
    }
    @Test
    public void edgeTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void cypressTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("http://example.cypress.io/");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void reactShoppingCartTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("http://react-shopping-cart-67954.firebaseapp.com/");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void findElement(){
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");

        //Start session ( opens browser)
        WebDriver driver = new ChromeDriver();

        //Navigate to this site
        driver.get("http://address-book-example.herokuapp.com");

        //Ensure browser in correct state when finding element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signIn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("sign-in")
                )
        );

        //Take action on element
        signIn.click();

        //Quit session (close browser)
        driver.quit();
    }

//    @Rule
//    public TestWatcher watcher = new TestWatcher() {
//        @Override
//        protected void failed(Throwable e, Description description){
//            System.out.println(description.getMethodName() + ": Failed");
//        }
//
//        @Override
//        protected void succeeded(Throwable e, Description description){
//            System.out.println(description.getMethodName() + ": Succeeded");
//        }
//    };
}
















