package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UnsuccessfulLogin extends TestUtil {

    @DataProvider(name = "wrongUsersList")
    public Object [][] getWrongUsers(){
        return new Object[][]{
                {"standardUser7", "secret_sauce"},
                {"standard_user", "wrong_password"},
                {"blah", "blah"}
        };
    }

    @Test(dataProvider = "wrongUsersList")
    public void UnsuccessfulLogin(String userName, String password){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        //loginPage.tryToLogin(userName, password);

        WebElement errorLoginLabel = driver.findElement(By.className("error-button"));
        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }
}
