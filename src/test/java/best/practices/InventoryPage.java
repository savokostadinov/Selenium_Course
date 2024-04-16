package best.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//This class represents a page object linked to https://www.saucedemo.com/inventory.html
public class InventoryPage {

    private final WebDriver driver;

    public InventoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Storing the sauce labs backpack in a method
    private WebElement sauceLabsBackpack()
    {
       return driver.findElement(By.className(""));
    }

    public void addToCart(SauceItem item)
    {
        //logic to add the appropriate item to the cart
       // driver.findElement(item).click();
    }

    public void goToCart()
    {
        //logic to add the appropriate item to the cart
        //driver.findElement("shopping cart").click();
    }

    public void open() {
    }
}
