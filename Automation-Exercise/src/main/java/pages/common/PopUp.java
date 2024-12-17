package pages.common;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.account.LoginPage;
import pages.order.CartPage;

public class PopUp extends PageBase {

    // Added to cart pop up
    private final By addedToCart = By.cssSelector("[class=\"modal-title w-100\"]");
    private final By continueShoppingBtn = By.cssSelector("[class=\"btn btn-success close-modal btn-block\"]");
    private final By viewCartBtn = By.linkText("View Cart");

    // checkout pop up
    private final By loginAndRegisterBtn = By.linkText("Register / Login");

    public PopUp(WebDriver driver){
        super(driver);
    }

    //========================= Added to cart pop up ===========================================
    public String getPopUpTitle() {
        return getText(addedToCart);
    }

    public HomePage clickContinueShopping() {
        clickElement(continueShoppingBtn);
        return new HomePage(driver);
    }

    public CartPage clickViewCartBtn() {
        clickElement(viewCartBtn);
        return new CartPage(driver);
    }
    //========================= Checkout pop up ===========================================

    public LoginPage clickLoginAndRegister(){
        clickElement(loginAndRegisterBtn);
        return new LoginPage(driver);
    }
}
