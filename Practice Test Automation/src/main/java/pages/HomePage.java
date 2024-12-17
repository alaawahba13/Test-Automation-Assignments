package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private final By loginBtn = By.linkText("Test Login Page");
    private final By exceptionBtn = By.linkText("Test Exceptions");


    public HomePage(WebDriver driver){
        this.driver =driver;
    }

    public LoginPage clickLogin(){
        driver.findElement(loginBtn).click();
        return new LoginPage(driver);
    }

    public ExceptionsPage clickExceptions(){
        driver.findElement(exceptionBtn).click();
        return new ExceptionsPage(driver);
    }

}
