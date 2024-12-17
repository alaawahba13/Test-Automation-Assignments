package pages.order;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.account.ConfirmationPage;

public class PaymentPage extends PageBase {

    private final By nameOnCard = By.name("name_on_card");
    private final By cardNo = By.name("card_number");
    private final By cvc = By.name("cvc");
    private final By month = By.name("expiry_month");
    private final By year = By.name("expiry_year");
    private final By confirmOrder = By.id("submit");


    public PaymentPage(WebDriver driver){
        super(driver);
    }

    public void setNameOnCard(String name) {
        setText(nameOnCard, name);
    }

    public void setCardNumber(String cardNumber) {
        setText(cardNo, cardNumber);
    }

    public void setCVC(String cvcCode) {
        setText(cvc, cvcCode);
    }

    public void setExpiryMonth(String expiryMonth) {
        setText(month, expiryMonth);
    }

    public void setExpiryYear(String expiryYear) {
        setText(year, expiryYear);
    }

    public ConfirmationPage clickConfirmOrder() {
        driver.findElement(confirmOrder).click();
        return new ConfirmationPage(driver);
    }

    public String getNameOnCard() {
        return getText(nameOnCard);
    }

    public String getCardNumber() {
        return getText(cardNo);
    }

    public String getCVC() {
        return getText(cvc);
    }

    public String getExpiryMonth() {
        return getText(month);
    }

    public String getExpiryYear() {
        return getText(year);
    }


}
