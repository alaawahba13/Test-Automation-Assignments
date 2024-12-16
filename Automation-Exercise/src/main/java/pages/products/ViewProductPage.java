package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.PageBase;
import pages.common.PopUp;


public class ViewProductPage extends PageBase {

    //items
    private final By itemTitle = By.cssSelector(".product-information h2");
    private final By itemPrice = By.cssSelector(".product-information span span");
    private final By itemQuantity = By.id("quantity");
    private final By addToCartBtn = By.cssSelector("[class=\"btn btn-default cart\"]");

    //review
    private final By nameTxt = By.id("name");
    private final By emailTxt = By.id("email");
    private final By reviewTxt = By.id("review");
    private final By submitBtn = By.id("button-review");
    private final By thanksLbl = By.cssSelector("#review-section span");


    public ViewProductPage(WebDriver driver) {
        super(driver);
    }

    public String getItemTitle() {
        return getText(itemTitle);
    }

    public String getItemPrice() {
        return getText(itemPrice);
    }

    public void setItemQuantity(String quantity) {
        WebElement textBox = driver.findElement(itemQuantity);
        textBox.clear();
        textBox.sendKeys(quantity);
    }

    public PopUp clickAddToCart() {
        clickElement(addToCartBtn);
        return new PopUp(driver);
    }

    //========================= Review  ===========================================

    public void enterReviewerName(String name) {
        setText(nameTxt, name);
    }

    public void enterReviewerEmail(String email) {
        setText(emailTxt, email);
    }

    public void enterReviewText(String review) {
        setText(reviewTxt, review);
    }

    public void clickSubmitReview() {
        clickElement(submitBtn);
    }

    public String getSubmitMsg() {
        return getText(thanksLbl);
    }

}
