package products;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC08_VerifyAllProductsAndDetails extends BaseTests {

    @Test(priority = 1)
    public void viewProducts(){
        productsPage = homePage.clickProducts();
        String title = productsPage.getProductsTitle();
        Assert.assertEquals(title,"ALL PRODUCTS");

    }

    @Test(priority = 2)
    @Parameters("index")
    public void testViewProductButton(@Optional("1") int index){
        String itemTitle = homePage.getItemTitle(index);
        String itemPrice = homePage.getItemPrice(index);
        viewProductPage = homePage.clickViewProduct(index);
        String url = viewProductPage.getPageURL();
        Assert.assertTrue(url.contains("product_details"),"Error Navigating to product page");
        Assert.assertEquals(viewProductPage.getItemTitle(),itemTitle,"Wrong Title");
        Assert.assertEquals(viewProductPage.getItemPrice(),itemPrice,"Wrong Price");

    }

}
