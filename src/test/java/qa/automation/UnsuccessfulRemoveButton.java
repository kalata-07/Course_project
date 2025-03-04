package qa.automation;

import base.TestUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductsPage;

public class UnsuccessfulRemoveButton extends TestUtil {
    @Test
    public void UnsuccessfulRemoveButton() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("error_user", "secret_sauce");
        productsPage.addItemToTheCart("backpack");
        //Thread.sleep(5000);
        productsPage.removeItemFromTheCart("backpack");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(productsPage.getItemsInTheCart(),0);
        System.out.println("It must be 0");
        softAssert.assertAll();
    }
}
