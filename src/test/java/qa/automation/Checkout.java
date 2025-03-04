package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutOverview;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;


public class Checkout extends TestUtil {


    @Test
    public void checkout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals( productsPage.getItemsInTheCart(),1);

        //Fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        fluentWait.until(ExpectedConditions.elementToBeClickable(shoppingCartBadge));
        shoppingCartBadge.click();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverview checkoutOverview = checkoutPage.continueCheckout("Kaloyan","Medov","4018");
        checkoutOverview.finishCheckout();
        checkoutOverview.backHome();
    }
}
