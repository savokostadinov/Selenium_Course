package web.driver.methods;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Date;
import java.util.Set;

public class webDriverMethodsQuiz {

    WebDriver driver;
    WebElement element;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resourc/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        element.click();
        WebElement option1 = element.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = element.findElement(By.cssSelector("option[value='2']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
    }

    @Test
    public void hoverImage(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        element = driver.findElement(By.xpath("//*[contains(text(),'name: user1')]"));
        Assert.assertTrue("user1 should appear because we hovered over that image", element.isDisplayed());
    }

    @Test
    public void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }

    @Test
    public void keyPresses(){
        driver.get("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target"));
        element.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).pause(1000).perform();

        element = driver.findElement(By.id("result"));
        Assert.assertEquals("Clicked right arrow key", "You entered: RIGHT", element.getText());
    }

    @Test
    public void getCSSValue(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.linkText("Clickable Icon"));
        String link = element.getAttribute("href");
        Assert.assertEquals("https://ultimateqa.com/link-success/", link);

        Assert.assertEquals("padding-box", element.getCssValue("background-origin"));
    }

    @Test
    public void findUpButton() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='et_pb_scroll_top et-pb-icon et-visible']")).isEnabled());
    }

    @Test
    public void clickUpButton(){
        driver.get("https://ultimateqa.com/complicated-page/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement button = driver.findElement(By.xpath("//span[@class='et_pb_scroll_top et-pb-icon et-visible']"));
        js.executeScript("arguments[0].click();", button);
//        button.click();
    }

    @Test
    public void windowsFrames() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://the-internet.herokuapp.com/windows/new');");

        String originalWindow = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        handles.remove(originalWindow);

        String nextWindow = String.valueOf(handles.iterator().next());

        driver.switchTo().window(nextWindow);
        Assert.assertEquals("New Window", driver.getTitle());

        driver.close();
        driver.switchTo().window(originalWindow);

        Assert.assertEquals("The Internet", driver.getTitle());
    }

    @Test
    public void frames(){
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        WebElement defaultFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(1);
        Assert.assertEquals("BOTTOM", driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertEquals("LEFT", driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.name("frame-top")).getSize().height > 0 );
    }

    @Test
    public void alerts(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[contains(normalize-space(text()), 'Click for JS Alert')]")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()), 'Click for JS Confirm')]")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()), 'Click for JS Prompt')]")).click();
        Alert inputAlert = driver.switchTo().alert();
        String text = inputAlert.getText();
        inputAlert.sendKeys("Look Mom! I can automate alerts :))");
        inputAlert.accept();
    }

    @Test
    public void jsAlert(){
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button1")).click();
        Alert myAlert = driver.switchTo().alert();
        Assert.assertEquals("I am an alert box!", myAlert.getText());
        myAlert.accept();
    }

    @Test
    public void jsConfirmBox() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button4")).click();
        driver.switchTo().alert().dismiss();
        WebElement message = driver.findElement(By.id("confirm-alert-text"));
        Assert.assertEquals("You pressed Cancel!", message.getText());
    }

    @Test
    public void cIsForCookie(){
        driver.get("http://example.com");

        Cookie cookie = new Cookie.Builder("name", "value")
                .domain("example.com")
                .expiresOn(new Date(2022, 11, 16))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/mypath")
                .build();

        driver.manage().addCookie(cookie);

        driver.get("http://example.com/mypath");

        Cookie found = driver.manage().getCookieNamed("name");
        Assert.assertEquals("value", found.getValue());
        driver.manage().deleteAllCookies();

        Assert.assertFalse(driver.manage().getCookies().contains(found));
    }
}
