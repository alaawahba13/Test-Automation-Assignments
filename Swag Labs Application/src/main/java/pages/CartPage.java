package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends PageBase{

    private final By productsTitle = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[1]");
    private final By productsPrice = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");

    public CartPage(AppiumDriver driver){
        super(driver);
    }
    public String getProductTitle(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle));
        return driver.findElements(productsTitle).get(index).getText();
    }

    public String getProductPrice(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPrice));
        return driver.findElements(productsPrice).get(index).getText();
    }

    public CheckoutPage clickCheckout(){
        scrollToTextAndClick("CHECKOUT");
        return new CheckoutPage(driver);
    }

}
