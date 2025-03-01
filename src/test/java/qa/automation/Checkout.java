package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class Checkout extends TestUtil {

    @Test
    public void checkout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals( productsPage.getItemsInTheCart(),1);

        WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        shoppingCartBadge.click();

        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();

    }
}
