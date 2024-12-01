package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameTextBox = By.id("username");
    private final By passTextBox = By.id("password");
    private final By submitBtn = By.id("submit");
    private final By errorLbl = By.id("error");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeUsername(String username){
        driver.findElement(usernameTextBox).sendKeys(username);
    }
    public void typePassword(String password){
        driver.findElement(passTextBox).sendKeys(password);
    }
    public LoginConfirmationPage clickSubmit(){
        driver.findElement(submitBtn).click();
        return new LoginConfirmationPage(driver);
    }
    public String getErrorMsg(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return  driver.findElement(errorLbl).getText();
    }

}
