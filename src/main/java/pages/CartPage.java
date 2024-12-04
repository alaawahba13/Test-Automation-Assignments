package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import static java.time.temporal.ChronoUnit.SECONDS;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By itemTitle = By.cssSelector(".cart_description a");
    private final By itemPrice = By.cssSelector(".cart_price p");
    private final By itemTotalPrice = By.className("cart_total_price");
    private final By itemQuantity = By.cssSelector(".cart_quantity button");
    private final By deleteItemBtn = By.className("cart_quantity_delete");
    private final By emptyCartTxt = By.cssSelector("#empty_cart p");
    private final By checkoutBtn = By.linkText("Proceed To Checkout");


    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    }

    public ArrayList<String> getItemsTitle(){
        ArrayList<String> titles = new ArrayList<>();
         List<WebElement> elements = driver.findElements(itemTitle);
         elements.forEach(element->{
             titles.add( element.getText());
         });
         return titles;

    }
    public ArrayList<String> getItemsPrice(){
        ArrayList<String> prices = new ArrayList<>();
        List<WebElement> elements = driver.findElements(itemPrice);
        elements.forEach(element->{
            prices.add( element.getText());
        });
        return prices;
    }
    public ArrayList<String> getItemsTotalPrice(){
        ArrayList<String> totalPrices = new ArrayList<>();
        List<WebElement> elements = driver.findElements(itemTotalPrice);
        elements.forEach(element->{
            totalPrices.add( element.getText());
        });
        return totalPrices;
    }
    public ArrayList<String> getItemsQuantity(){
        ArrayList<String> quantity = new ArrayList<>();
        List<WebElement> elements = driver.findElements(itemQuantity);
        elements.forEach(element->{
            quantity.add( element.getText());
        });
        return quantity;
    }

    public void removeCartItem(int index){
//         int  index =0 ;
//        List<WebElement> elements = driver.findElements(itemTitle);
//        for(WebElement element :elements){
//            if(element.getText().contains(title)){
//                WebElement btn  = driver.findElements(deleteItemBtn).get(index);
//                btn.click();
//                wait.until(ExpectedConditions.invisibilityOf(btn));
//                break;
//            }
//            index++;
//        }
        driver.findElements(deleteItemBtn).get(index).click();

    }
    public void emptyCart(){

        List<WebElement> elements = driver.findElements(deleteItemBtn);
        elements.forEach(element -> {
            element.click();
        });

    }
    public String getEmptyCartText(){
        return driver.findElement(emptyCartTxt).getText();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }

}
