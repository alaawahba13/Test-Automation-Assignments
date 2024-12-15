package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends PageBase{

    private final By pageHeader = AppiumBy.accessibilityId("test-Cart drop zone");
    private final By productNames = By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]");
    private final By productPrices = By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");
    private final By addToCartBtns = By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]");
    private final By cartBtn = AppiumBy.accessibilityId("test-Cart");

    public ProductsPage(AppiumDriver driver){
        super(driver);
    }

    public boolean isPageHeaderPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return driver.findElement(pageHeader).isDisplayed();
    }

    public String getProductTitle(int index){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(productNames)));
        return driver.findElements(productNames).get(index).getText();
    }

    public String getProductPrice(int index){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(productPrices)));
       return driver.findElements(productPrices).get(index).getText();
    }
    public void clickAddToCart(int index){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtns));
        driver.findElements(addToCartBtns).get(index).click();
    }
    public CartPage goToCart(){
        clickElement(cartBtn);
        return new CartPage(driver);
    }

}
