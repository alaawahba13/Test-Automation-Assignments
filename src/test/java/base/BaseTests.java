package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTests {
    public static WebDriver driver;
    protected static HomePage homePage;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
