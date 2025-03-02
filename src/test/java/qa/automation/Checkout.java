package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutOverview;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;


public class Checkout extends TestUtil {

    @Test
    public void checkout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals( productsPage.getItemsInTheCart(),1);

        WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        shoppingCartBadge.click();

        Thread.sleep(5000);
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();
        Thread.sleep(5000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverview checkoutOverview = checkoutPage.continueCheckout("Kaloyan","Medov","4018");
        Thread.sleep(5000);
        checkoutOverview.finishCheckout();
        Thread.sleep(5000);
        checkoutOverview.backHome();
        Thread.sleep(5000);
    }
}
