package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage extends HomePage{

    private final By searchBar = By.id("search_product");
    private final By searchBtn = By.id("submit_search");


    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }


    public void searchItem(String item){
        driver.findElement(searchBar).sendKeys(item);
        driver.findElement(searchBtn).click();
    }


}
