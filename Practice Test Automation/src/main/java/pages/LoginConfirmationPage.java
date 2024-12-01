package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginConfirmationPage {
    private final WebDriver driver;

    private final By title = By.className("post-title");
    private final By logoutBtn = By.cssSelector("div.post-content a");

    public LoginConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public String getLogout(){
        return driver.findElement(logoutBtn).getText();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }

}
