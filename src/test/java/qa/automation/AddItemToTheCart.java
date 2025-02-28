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
        //productsPage.removeItemFromTheCart("bike-light");
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(productsPage.getItemsInTheCart(),0);
        //System.out.println("I will be executed");
        //softAssert.assertAll();
    }
}
