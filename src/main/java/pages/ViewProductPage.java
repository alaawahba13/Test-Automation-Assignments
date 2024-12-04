package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class ViewProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By itemTitle = By.cssSelector(".product-information h2");
    private final By itemPrice = By.cssSelector(".product-information span span");
    private final By itemQuantity = By.id("quantity");
    private final By addToCartBtn = By.cssSelector("[class=\"btn btn-default cart\"]");

    //review
    private final By nameTxt = By.id("name");
    private final By emailTxt = By.id("email");
    private final By reviewTxt = By.id("review");
    private final By submitBtn = By.id("button-review");
    private final By thanksLbl = By.cssSelector(".alert-success alert span");



    public ViewProductPage(WebDriver driver){
        this.driver = driver;
        wait =new WebDriverWait(driver, Duration.of(60, SECONDS));
    }

    public String getItemTitle() {
        return driver.findElement(itemTitle).getText();
    }
    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }
    public void setItemQuantity(String quantity) {
        WebElement textBox = driver.findElement(itemQuantity);
        textBox.clear();
        textBox.sendKeys(quantity);
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }
    public void enterReviewerName(String name) {
        driver.findElement(nameTxt).sendKeys(name);
    }
    public void enterReviewerEmail(String email) {
        driver.findElement(emailTxt).sendKeys(email);
    }
    public void enterReviewText(String review) {
        driver.findElement(reviewTxt).sendKeys(review);
    }
    public void clickSubmitReview() {
        driver.findElement(submitBtn).click();
    }
    public String getSubmitMsg(){
        return driver.findElement(thanksLbl).getText();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }



}
