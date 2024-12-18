package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.account.ConfirmationPage;
import pages.account.LoginPage;
import pages.common.ContactUsPage;
import pages.common.HomePage;
import pages.common.PopUp;
import pages.order.CartPage;
import pages.order.CheckoutPage;
import pages.order.PaymentPage;
import pages.products.ProductsPage;
import pages.products.ViewProductPage;

import java.util.HashMap;
import java.util.Map;

public class BaseTests {
    public static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static ConfirmationPage confirmationPage;
    protected static ProductsPage productsPage;
    protected static ViewProductPage viewProductPage;
    protected static CartPage cartPage;
    protected static ContactUsPage contactUsPage;
    protected static PopUp popUp;
    protected static CheckoutPage checkoutPage;
    protected static PaymentPage paymentPage;

    @BeforeClass
    public void setup(){
        String downloadFilepath = System.getProperty("user.dir");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath); // Set the download folder
        prefs.put("profile.default_content_settings.popups", 0);   // Disable download pop-up

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--headless"); // Run in headless mode
        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
