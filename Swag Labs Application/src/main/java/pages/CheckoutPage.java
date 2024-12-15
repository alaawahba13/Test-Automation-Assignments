package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends PageBase{

    // information
    private final By firstNameTxt = AppiumBy.accessibilityId("test-First Name");
    private final By lastNameTxt = AppiumBy.accessibilityId("test-Last Name");
    private final By zipCodeTxt = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private final By continueBtn = AppiumBy.accessibilityId("test-CONTINUE");

    // review
    private final By productsTitle = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[1]");
    private final By productsPrice = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");

    // complete
    private final By completeTitle = By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]//android.widget.TextView[1]");

    public CheckoutPage(AppiumDriver driver){
        super(driver);
    }

    public void typeFirstName(String firstName){
        setText(firstNameTxt,firstName);
    }
    public void typeLastName(String lastName){
        setText(lastNameTxt,lastName);
    }
    public void typeZipCode(String zipCode){
        setText(zipCodeTxt,zipCode);
    }
    public void clickContinue(){
        clickElement(continueBtn);
    }


    public String getProductTitle(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle));
        return driver.findElements(productsTitle).get(index).getText();
    }

    public String getProductPrice(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPrice));
        return driver.findElements(productsPrice).get(index).getText();
    }
    public void clickFinish(){
        scrollToTextAndClick("FINISH");
    }

    public String getCompleteTitle(){
        return getText(completeTitle);
    }


}
