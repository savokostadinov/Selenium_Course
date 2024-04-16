package best.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {
    private WebDriver driver;

    private WebElement getFirstNameField(){
        return driver.findElement(By.id("first-name"));
    }
    private WebElement getLastNameField(){
        return driver.findElement(By.id("last-name"));
    }
    private WebElement getZipCodeField(){
        return driver.findElement(By.id("postal-code"));
    }

    public void fillOutPersonalInformation(){
        getFirstNameField().sendKeys("FirstName");
        getLastNameField().sendKeys("LastName");
        getZipCodeField().sendKeys("ZipCode");
    }
}
