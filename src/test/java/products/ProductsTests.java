package products;

import base.BaseTests;
import base.Data;
import cart.CartTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductsPage;

import java.util.ArrayList;

public class ProductsTests  extends BaseTests {
    public static ProductsPage productsPage;

    @Test
    public void viewProducts(){
        productsPage = homePage.clickProducts();
        String title = productsPage.getTitle();
        Assert.assertEquals(title,"ALL PRODUCTS");
    }

    @Test(dependsOnMethods = "viewProducts")
    public void testSearchForItem(){
        productsPage.searchItem("dress");
        String title = productsPage.getTitle();
        Assert.assertEquals(title,"SEARCHED PRODUCTS","Error searching");
        int size=  productsPage.getNumberOfItems();
        Assert.assertTrue(size> 1);
    }


    @Test( dataProviderClass = Data.class, dataProvider = "category")
    public void testFilterByCategory( String gender, String itemCategory){
       productsPage =  homePage.filterByGenderCategory(gender, itemCategory);
        String title = productsPage.getTitle();
        Assert.assertEquals(title,gender.toUpperCase()+" - "+itemCategory.toUpperCase()+" PRODUCTS");
    }

    @Test(dataProviderClass = Data.class, dataProvider = "brand")
    public void testFilterByBrand(String brandName){
        productsPage =  homePage.filterByBrand(brandName);
        String title =  productsPage.getTitle();
        Assert.assertEquals(title,"BRAND - "+brandName+" PRODUCTS");
    }


    @Test
    @Parameters("index")
    public void testAddToCartFromProducts(int index){
        String itemTitle = homePage.getItemTitle(index);
        String itemPrice = homePage.getItemPrice(index);
        homePage.addItemToCart(index);
        CartTests cartTests = new CartTests();
        cartTests.verifyAddToCart(itemTitle,itemPrice,"1");
    }
    

}
