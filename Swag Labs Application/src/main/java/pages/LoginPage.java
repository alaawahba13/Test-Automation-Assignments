package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    private final By loginBtn = AppiumBy.accessibilityId("test-LOGIN");

    public LoginPage(AppiumDriver driver){
        super(driver);
    }

    public void autoFillCredentials(String text){
        scrollToTextAndClick(text);
    }

    public ProductsPage clickLoginBtn(){
         scrollUp();
        clickElement(loginBtn);
        return new ProductsPage(driver);
    }


}
