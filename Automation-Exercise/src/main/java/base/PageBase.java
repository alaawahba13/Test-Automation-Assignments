package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.account.AccountConfirmationPage;
import pages.account.LoginPage;
import pages.common.ContactUsPage;
import pages.common.TestCasesPage;
import pages.order.CartPage;
import pages.products.ProductsPage;



public class PageBase extends Common {


    public PageBase(WebDriver driver) {
        super(driver);
    }

    //header
    private final By logInBtn = By.xpath("//a[@href=\"/login\"]");
    private final By logOutBtn = By.linkText("Logout");
    private final By loggedInLbl = By.xpath("//i[@class=\"fa fa-user\"]//parent::a");
    private final By deleteAccountBtn = By.linkText("Delete Account");
    private final By productsBtn = By.xpath("//a[@href=\"/products\"]");
    private final By cartBtn = By.linkText("Cart");
    private final By contactUsBtn = By.linkText("Contact us");
    private final By testCasesBtn = By.linkText("Test Cases");

    // subscription
    private final By subscriptionTitle = By.className("single-widget");
    private final By subscribeEmail = By.id("susbscribe_email");
    private final By subscribeBtn = By.id("subscribe");
    private final By subscribeSuccessMsg = By.cssSelector("[class=\"alert-success alert\"]");

    //Scroll up
    private final By scrollUpBtn = By.id("scrollUp");
    private final By headerTxt = By.cssSelector(".col-sm-6 h2");


    //========================= header ===========================================

    public LoginPage clickLogIn() {
        clickElement(logInBtn);
        return new LoginPage(driver);
    }

    public LoginPage clickLogOut() {
        clickElement(logOutBtn);
        return new LoginPage(driver);
    }

    public AccountConfirmationPage clickDeleteAccount() {
        clickElement(deleteAccountBtn);
        return new AccountConfirmationPage(driver);
    }

    public ProductsPage clickProducts() {
        clickElement(productsBtn);
        return new ProductsPage(driver);
    }

    public CartPage clickCart() {
        clickElement(cartBtn);
        return new CartPage(driver);
    }

    public ContactUsPage clickContactUs() {
        clickElement(contactUsBtn);
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickTestCases() {
        clickElement(testCasesBtn);
        return new TestCasesPage(driver);
    }

    public String getLoggedInLbl() {
        return getText(loggedInLbl);
    }


    //========================= Subscription ===========================================



    public String getSubscriptionTitle() {
        return getText(subscriptionTitle);
    }

    public void enterSubscribeEmail(String email) {
        setText(subscribeEmail,email);
    }

    public void clickSubscribeButton() {
        clickElement(subscribeBtn);
    }

    public String getSubscribeSuccessMessage() {
        return getText(subscribeSuccessMsg);
    }

    //========================= scroll up  ===========================================
    public void clickScrollUp() {
        clickElement(scrollUpBtn);
    }
    public void scrollToItem(String text) {
        scrollToText(text);
    }
    public void scrollDown (){
        scrollToTheBottom();
    }
    public String getHeaderText() {
        return getText(headerTxt);
    }



}
