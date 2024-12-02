package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    private  final By logInBtn = By.xpath("//a[@href=\"/login\"]");
    private final By logOutBtn = By.linkText("Logout");
    private final By loggedInLbl = By.xpath("//i[@class=\"fa fa-user\"]//parent::a");
    private final By deleteAccountBtn = By.linkText("Delete Account");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLogIn(){
        clickElement(logInBtn);
        return new LoginPage(driver);
    }

    public LoginPage clickLogOut(){
        clickElement(logOutBtn);
        return new LoginPage(driver);
    }
    public AccountConfirmationPage clickDeleteAccount(){
        clickElement(deleteAccountBtn);
        return new AccountConfirmationPage(driver);
    }

    public String getLoggedInLbl(){
        return driver.findElement(loggedInLbl).getText();
    }


    private void clickElement(By element){
        driver.findElement(element).click();
    }
}
