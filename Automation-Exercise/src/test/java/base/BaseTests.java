package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.account.LoginPage;
import pages.common.ContactUsPage;
import pages.common.HomePage;
import pages.common.PopUp;
import pages.order.CartPage;
import pages.products.ProductsPage;
import pages.products.ViewProductPage;

public class BaseTests {
    public static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static ProductsPage productsPage;
    protected static ViewProductPage viewProductPage;
    protected static CartPage cartPage;
    protected static ContactUsPage contactUsPage;
    protected static PopUp popUp;

    @BeforeClass
    public void setup(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // Run in headless mode
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
