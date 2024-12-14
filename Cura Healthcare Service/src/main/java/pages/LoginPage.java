package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    private final By usernameTxt = By.id("txt-username");
    private final By passwordTxt = By.id("txt-password");
    private final By loginBtn = By.id("btn-login");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void typeUsername(String username){
        sendKeys(usernameTxt,username);
    }
    public void typePassword(String password){
        sendKeys(passwordTxt,password);
    }
    public AppointmentPage clickLogin(){
        clickElement(loginBtn);
        return new AppointmentPage(driver);
    }

}
