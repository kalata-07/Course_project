package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutOverview {
    protected WebDriver driver;

    public CheckoutOverview(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void finishCheckout(){
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }

    public void backHome(){
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        Assert.assertTrue(backHomeButton.isEnabled());
        backHomeButton.click();
    }
}
