package pages.order;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageBase {

    private final By commentTxt = By.name("message");
    private final By placeOrder = By.linkText("Place Order");
    private final By addressAndCheckoutLbl = By.cssSelector(".step-one h2");

    private final By deliveryFirstLastName = By.cssSelector("#address_delivery [class=\"address_firstname address_lastname\"]");
    private final By deliveryAddress  =By.cssSelector("#address_delivery [class=\"address_address1 address_address2\"]");
    private final By deliveryCityStatePostCode = By.cssSelector("#address_delivery [class=\"address_city address_state_name address_postcode\"]");
    private final By deliveryCountry = By.cssSelector("#address_delivery [class=\"address_country_name\"]");
    private final By deliveryPhoneNo = By.cssSelector("#address_delivery [class=\"address_phone\"]");

    private final By billingFirstLastName = By.cssSelector("#address_invoice [class=\"address_firstname address_lastname\"]");
    private final By billingAddress = By.cssSelector("#address_invoice [class=\"address_address1 address_address2\"]");
    private final By billingCityStatePostCode = By.cssSelector("#address_invoice [class=\"address_city address_state_name address_postcode\"]");
    private final By billingCountry = By.cssSelector("#address_invoice [class=\"address_country_name\"]");
    private final By billingPhoneNo = By.cssSelector("#address_invoice [class=\"address_phone\"]");


    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public void setCommentTxt(String comment){
        setText(commentTxt,comment);
    }
    public PaymentPage clickPlaceOrder(){
        clickElement(placeOrder);
        return new PaymentPage(driver);
    }
    public boolean isAddressAndCheckoutDisplayed(){
        return driver.findElements(addressAndCheckoutLbl).size() == 2 ;
    }


    public String getDeliveryFirstLastName() {
        return getText(deliveryFirstLastName);
    }

    public String getDeliveryAddress() {
        return   driver.findElements(deliveryAddress).get(1).getText();
    }

    public String getDeliveryCityStatePostCode() {
        return getText(deliveryCityStatePostCode);
    }

    public String getDeliveryCountry() {
        return getText(deliveryCountry);
    }

    public String getDeliveryPhoneNo() {
        return getText(deliveryPhoneNo);
    }

    public String getBillingFirstLastName() {
        return getText(billingFirstLastName);
    }

    public String getBillingAddress() {
        return   driver.findElements(billingAddress).get(1).getText();
    }

    public String getBillingCityStatePostCode() {
        return getText(billingCityStatePostCode);
    }

    public String getBillingCountry() {
        return getText(billingCountry);
    }

    public String getBillingPhoneNo() {
        return getText(billingPhoneNo);
    }


}
