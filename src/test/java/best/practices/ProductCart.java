package best.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCart {
    private WebDriver driver;

    private WebElement getCheckOutButton(){
        return driver.findElement(By.id("checkout"));
    }

    public void startCheckOut(){
        getCheckOutButton().click();
    }
}
