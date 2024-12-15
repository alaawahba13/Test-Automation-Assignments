package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {
    AppiumDriver driver ;
    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;

    @BeforeTest
    @Parameters({"appPath","platformVersion","platformName","automationName","deviceName"})
    public void setUp(@Optional("D:\\Courses\\Career180 Testing\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk") String appPath,
                      @Optional("13.0") String platformVersion,
                      @Optional("Android") String platformName,
                      @Optional("UiAutomator2") String automationName,
                      @Optional("emulator-5554") String deviceName) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(appPath);
        options.setPlatformVersion(platformVersion);
        options.setPlatformName(platformName);
        options.setAutomationName(automationName);
        options.setDeviceName(deviceName);
        options.setAppWaitActivity("com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(  new URL("http://127.0.0.1:4723/"),options);
        loginPage = new LoginPage(driver);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
