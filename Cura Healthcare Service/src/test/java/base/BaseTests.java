package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AppointmentConfirmationPage;
import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;

public class BaseTests {
    public static WebDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static AppointmentPage appointmentPage;
    public static AppointmentConfirmationPage appointmentConfirmationPage;
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
