package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class HomePage {
    protected   WebDriver driver;
    private WebDriverWait wait;

    //header
    private  final By logInBtn = By.xpath("//a[@href=\"/login\"]");
    private final By logOutBtn = By.linkText("Logout");
    private final By loggedInLbl = By.xpath("//i[@class=\"fa fa-user\"]//parent::a");
    private final By deleteAccountBtn = By.linkText("Delete Account");
    private final By productsBtn = By.xpath("//a[@href=\"/products\"]");
    private final By cartBtn = By.linkText("Cart");

    //title
    private final By centerTitle = By.cssSelector("[class=\"title text-center\"]");

    // item related
    private final By productsItems = By.cssSelector("[class=\"productinfo text-center\"]");
    private final By itemTitle = By.cssSelector("[class=\"productinfo text-center\"] p");
    private final By itemPrice = By.cssSelector("[class=\"productinfo text-center\"] h2");
    private final By viewProductBtn = By.linkText("View Product");
    private final By addToCartBtn = By.cssSelector("[class=\"btn btn-default add-to-cart\"]");

    // pop up
    private final By addedToCart = By.cssSelector("[class=\"modal-title w-100\"]");
    private final By continueShoppingBtn = By.cssSelector("[class=\"btn btn-success close-modal btn-block\"]");
    private final By viewCartBtn = By.linkText("View Cart");

    // filter
    private final By genderBtn = By.cssSelector(".panel-title a");
    private final By clothesCategory = By.cssSelector(".panel-body li a");
    private final By brandsBtn = By.cssSelector(".brands-name li");

    // recommended items
    private final By recommendedItemsTitle = By.cssSelector(".recommended_items>h2");
    private final By recommendedItems = By.id("recommended-item-carousel");

    public HomePage(){

    }
    public HomePage(WebDriver driver){
        this.driver = driver;
        wait =new WebDriverWait(driver, Duration.of(60, SECONDS));
    }

    //========================= header ===========================================

    public LoginPage clickLogIn(){
        clickElement(logInBtn);
        return new LoginPage(driver);
    }

    public LoginPage clickLogOut(){
        clickElement(logOutBtn);
        return new LoginPage(driver);
    }
    public AccountConfirmationPage clickDeleteAccount(){
        clickElement(deleteAccountBtn);
        return new AccountConfirmationPage(driver);
    }
    public ProductsPage clickProducts(){
        driver.findElement(productsBtn).click();
        return new ProductsPage(driver);
    }

    public CartPage clickCart(){
        driver.findElement(cartBtn).click();
        return new CartPage(driver);
    }

    public String getLoggedInLbl(){
        return driver.findElement(loggedInLbl).getText();
    }

    public String getTitle(){
        return driver.findElement(centerTitle).getText();
    }


    //========================= items ===========================================

    public int getNumberOfItems(){
        return driver.findElements(productsItems).size();
    }
    public String getItemTitle(int index){
        return driver.findElements(itemTitle).get(index).getText();
    }
    public String getItemPrice(int index){
        return driver.findElements(itemPrice).get(index).getText();
    }
    public void addItemToCart(int index){
        Actions action = new Actions(driver);
        action.moveToElement( driver.findElements(productsItems).get(index)).perform();
        driver.findElements(addToCartBtn).get(index*2).click();
    }
    public ViewProductPage clickViewProduct(int index){
        driver.findElements(viewProductBtn).get(index).click();
        return new ViewProductPage(driver);
    }

    //========================= recommended items ===========================================
    public void addRecommendedItemToCart(int index){

    }

    //========================= pop up ===========================================
    public String getPopUpTitle(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addedToCart)));
        return driver.findElement(addedToCart).getText();
    }
    public void clickContinueShopping(){
        clickElement(continueShoppingBtn);
    }
    public CartPage clickViewCartBtn(){
        clickElement(viewCartBtn);
        return new CartPage(driver);
    }


    public ProductsPage filterByBrand(String brandName){
        List<WebElement> brands =  driver.findElements(brandsBtn);
        for(WebElement brand : brands){
            if(brand.getText().contains(brandName)){
                brand.click();
                break;
            }
        }
        return new ProductsPage(driver);
    }

    public ProductsPage filterByGenderCategory(String gender, String itemCategory){
        List<WebElement> genders =  driver.findElements(genderBtn);
        for(WebElement g : genders){
            if(g.getDomAttribute("href").equals("#"+gender)){
                g.click();
                selectItemCategory(itemCategory);
                break;
            }
        }
        return new ProductsPage(driver);
    }

    private void selectItemCategory(String itemCategory){
        List<WebElement> items =  driver.findElements(clothesCategory);
        for(WebElement item : items){
            if(item.getText().toLowerCase().contains(itemCategory.toLowerCase())){
                wait.until(ExpectedConditions.elementToBeClickable(item));
                item.click();
                break;
            }
        }
    }

    // helper method
    private void clickElement(By element){
        driver.findElement(element).click();
    }

}
