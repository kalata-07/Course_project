package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    private String url; // ="https://www.saucedemo.com/v1/";
    private String browser;
    private int implicitWait;

    @BeforeMethod
    public void setUp() throws IOException {
        setupBrowserDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    private void setupBrowserDriver() throws IOException {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){

            Properties config = new Properties();
            config.load(configFile);
            url=config.getProperty("urlAddress");
            browser=config.getProperty("browser");
            implicitWait=Integer.parseInt(config.getProperty("implicitWait"));

        }catch (IOException e){
            System.out.println("Can not read configs");
        }

        switch (browser){
            case "chrome":
                getChromeDriver(url, implicitWait);
                break;
            case "edge":
                getEgdeDriver(url, implicitWait);
                break;
            default:
                throw new IllegalStateException("Unsupported browser type");
        }
    }

    private void loadUrl(String url){
        driver.get(url);
    }

    private void getChromeDriver(String url, int implicitWait){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        loadUrl(url);
    }

    private void getEgdeDriver(String url, int implicitWait){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        loadUrl(url);
    }
}
