package pages.common;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.products.ProductsPage;
import pages.products.ViewProductPage;

import java.util.List;

public class HomePage extends PageBase {


    //title
    private final By productsTitle = By.cssSelector("[class=\"title text-center\"]");

    // item related
    private final By productsItems = By.cssSelector("[class=\"productinfo text-center\"]");
    private final By itemTitle = By.cssSelector("[class=\"productinfo text-center\"] p");
    private final By itemPrice = By.cssSelector("[class=\"productinfo text-center\"] h2");
    private final By viewProductBtn = By.linkText("View Product");
    private final By addToCartBtn = By.cssSelector("[class=\"btn btn-default add-to-cart\"]");


    // filter
    private final By genderBtn = By.cssSelector(".panel-title a");
    private final By clothesCategory = By.cssSelector(".panel-body li a");
    private final By brandsBtn = By.cssSelector(".brands-name li");

    // recommended items
    private final By recommendedItemsHeader = By.cssSelector(".recommended_items>h2");
    private final By recommendedAddToCart = By.xpath("//div[@class=\"item active\"]//a[@class=\"btn btn-default add-to-cart\"]");
    private final By recommendedItemsTitle = By.xpath("//div[@class=\"item active\"]//div[@class=\"productinfo text-center\"]//p");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getProductsTitle() {
        return getText(productsTitle);
    }

    //========================= items ===========================================

    public int getNumberOfItems() {
        return driver.findElements(productsItems).size();
    }

    public String getItemTitle(int index) {
        return driver.findElements(itemTitle).get(index).getText();
    }

    public String getItemPrice(int index) {
        return driver.findElements(itemPrice).get(index).getText();
    }

    public PopUp addItemToCart(int index) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElements(productsItems).get(index)).perform();
        driver.findElements(addToCartBtn).get(index * 2).click();
        return new PopUp(driver);
    }

    public ViewProductPage clickViewProduct(int index) {
        driver.findElements(viewProductBtn).get(index).click();
        return new ViewProductPage(driver);
    }

    //========================= recommended items ===========================================
    public PopUp addRecommendedItemToCart(int index) {
        driver.findElements(recommendedAddToCart).get(index).click();
        return new PopUp(driver);
    }
    public String getRecommendedTitle(){
        return getText(recommendedItemsHeader);
    }
    public String getRecommendedItemTitle(int index){
        return driver.findElements(recommendedItemsTitle).get(index).getText();
    }

    //========================= Filter ===========================================

    public ProductsPage filterByBrand(String brandName) {
        List<WebElement> brands = driver.findElements(brandsBtn);
        for (WebElement brand : brands) {
            if (brand.getText().contains(brandName)) {
                brand.click();
                break;
            }
        }
        return new ProductsPage(driver);
    }

    public ProductsPage filterByGenderCategory(String gender, String itemCategory) {
        List<WebElement> genders = driver.findElements(genderBtn);
        for (WebElement g : genders) {
            if (g.getDomAttribute("href").equals("#" + gender)) {
                g.click();
                selectItemCategory(itemCategory);
                break;
            }
        }
        return new ProductsPage(driver);
    }

    private void selectItemCategory(String itemCategory) {
        List<WebElement> items = driver.findElements(clothesCategory);
        for (WebElement item : items) {
            if (item.getText().toLowerCase().contains(itemCategory.toLowerCase())) {
                wait.until(ExpectedConditions.elementToBeClickable(item));
                item.click();
                break;
            }
        }
    }



}
