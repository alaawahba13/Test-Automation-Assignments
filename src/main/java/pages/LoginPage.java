package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By loginEmailTxtBox = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By loginPasswordTxtBox = By.name("password");
    private final By loginBtn = By.xpath("//button[@data-qa=\"login-button\"]");
    private final By loginErrorMsg = By.xpath("//form[@action=\"/login\"]//p");

    private final By signUpNameTxtBox = By.name("name");
    private final By signUpEmailTxtBox = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUpBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By signUpErrorMsg = By.xpath("//form[@action=\"/signup\"]//p");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeLoginEmail(String email){
        driver.findElement(loginEmailTxtBox).sendKeys(email);
    }

    public void typeLoginPassword(String password){
        driver.findElement(loginPasswordTxtBox).sendKeys(password);
    }

    public HomePage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new HomePage(driver);
    }

    public void clearLoginFields(){
        driver.findElement(loginEmailTxtBox).clear();
        driver.findElement(loginPasswordTxtBox).clear();
    }

    public String getLoginErrorMsg(){
        return driver.findElement(loginErrorMsg).getText();
    }

    public String getLoginToolTipMsg(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return  (String) js.executeScript("return arguments[0].validationMessage;", driver.findElement(loginEmailTxtBox));
    }


    public void typeSignUpName(String name){
        driver.findElement(signUpNameTxtBox).sendKeys(name);
    }
    public void typeSignUpEmail(String email){
        driver.findElement(signUpEmailTxtBox).sendKeys(email);
    }
    public SignUpPage clickSignUpBtn(){
        driver.findElement(signUpBtn).click();
        return new SignUpPage(driver);
    }
    public String getSignupToolTipMsg(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return  (String) js.executeScript("return arguments[0].validationMessage;", driver.findElement(signUpEmailTxtBox));
    }
    public String getSignupErrorMsg(){
        return driver.findElement(signUpErrorMsg).getText();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

}
