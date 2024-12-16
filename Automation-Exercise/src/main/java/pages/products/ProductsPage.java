package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.common.HomePage;


public class ProductsPage extends HomePage {

    private final By searchBar = By.id("search_product");
    private final By searchBtn = By.id("submit_search");


    public ProductsPage(WebDriver driver){
       super(driver);
    }


    public void searchItem(String item){
        setText(searchBar,item);
        clickElement(searchBtn);
    }


}
