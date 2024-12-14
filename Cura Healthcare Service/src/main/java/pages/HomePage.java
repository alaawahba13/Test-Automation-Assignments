package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  extends PageBase{

    private final By menu = By.id("menu-toggle");
    private final By loginBtn = By.linkText("Login");
    private final By logoutBtn = By.linkText("Logout");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickMenu(){
        clickElement(menu);
    }

    public LoginPage clickLogin(){
        clickElement(menu);
        clickElement(loginBtn);
        return new LoginPage(driver);
    }

    public void clickLogout(){
        clickElement(menu);
        clickElement(logoutBtn);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }


}
