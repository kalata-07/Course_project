package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(id="user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "error-button")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage login(String username, String password){
        usernameInput.click();
        usernameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.sendKeys(password);

        loginButton.click();

        return new ProductsPage(driver);
    }

    public void tryToLogin(String username, String password){
        usernameInput.click();
        usernameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.sendKeys(password);

        loginButton.click();

        try {
            WebElement productsMenu = driver.findElement(By.id("react-burger-menu-btn"));
        }catch (NoSuchElementException e){
            // Handle the exception if needed
        }
    }

    public boolean isLoginErrorMessageShown(){

  //      try {
  //          return errorMessage.isDisplayed();
  //      }catch (NoSuchElementException e){
   //         // do some logic
  //         return false;
  //      }
        return errorMessage.isDisplayed();
    }
}
