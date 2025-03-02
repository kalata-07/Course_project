package qa.automation;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class AddItemToTheCart extends TestUtil {
    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals( productsPage.getItemsInTheCart(),1);

        productsPage.addItemToTheCart("backpack");
        Assert.assertEquals( productsPage.getItemsInTheCart(),2);

        productsPage.removeItemFromTheCart("bike-light");
        Assert.assertEquals(productsPage.getItemsInTheCart(),1);
    }
}
