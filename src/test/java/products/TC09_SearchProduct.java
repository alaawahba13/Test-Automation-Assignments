package products;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_SearchProduct extends BaseTests {

    @Test(priority = 1)
    public void viewProducts(){
        productsPage = homePage.clickProducts();
        String title = productsPage.getProductsTitle();
        Assert.assertEquals(title,"ALL PRODUCTS");

    }
    @Test(dependsOnMethods = "viewProducts")
    public void testSearchForItem(){
        productsPage.searchItem("dress");
        String title = productsPage.getProductsTitle();
        Assert.assertEquals(title,"SEARCHED PRODUCTS","Error searching");
        int size=  productsPage.getNumberOfItems();
        Assert.assertTrue(size> 1);
    }

}
