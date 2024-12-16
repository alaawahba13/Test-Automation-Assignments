package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import base.PageBase;
import pages.common.HomePage;

public class LoginPage extends PageBase {



    private final By loginEmailTxtBox = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By loginPasswordTxtBox = By.name("password");
    private final By loginBtn = By.xpath("//button[@data-qa=\"login-button\"]");
    private final By loginErrorMsg = By.xpath("//form[@action=\"/login\"]//p");

    private final By signUpNameTxtBox = By.name("name");
    private final By signUpEmailTxtBox = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUpBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By signUpErrorMsg = By.xpath("//form[@action=\"/signup\"]//p");


    public LoginPage(WebDriver driver) {
       super(driver);
    }

    public void typeLoginEmail(String email) {
        setText(loginEmailTxtBox,email);
    }

    public void typeLoginPassword(String password) {
        setText(loginPasswordTxtBox,password);
    }

    public HomePage clickLoginBtn() {
        clickElement(loginBtn);
        return new HomePage(driver);
    }

    public void clearLoginFields() {
        driver.findElement(loginEmailTxtBox).clear();
        driver.findElement(loginPasswordTxtBox).clear();
    }

    public String getLoginErrorMsg() {
        return getText(loginErrorMsg);
    }

    public String getLoginToolTipMsg() {
        return getTooltipMsg(loginEmailTxtBox);
    }


    public void typeSignUpName(String name) {
       setText(signUpNameTxtBox,name);
    }

    public void typeSignUpEmail(String email) {
        setText(signUpEmailTxtBox,email);
    }

    public SignUpPage clickSignUpBtn() {
       clickElement(signUpBtn);
        return new SignUpPage(driver);
    }

    public String getSignupToolTipMsg() {
        return getTooltipMsg(signUpEmailTxtBox);
    }

    public String getSignupErrorMsg() {
        return getText(signUpErrorMsg);
    }

}
