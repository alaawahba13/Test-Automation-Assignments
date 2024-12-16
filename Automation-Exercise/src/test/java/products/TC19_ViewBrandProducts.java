package products;

import base.BaseTests;
import base.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC19_ViewBrandProducts extends BaseTests {

    @Test(dataProviderClass = Data.class, dataProvider = "brand")
    public void testFilterByBrand(String brandName){
        productsPage =  homePage.filterByBrand(brandName);
        String title =  productsPage.getProductsTitle();
        Assert.assertEquals(title,"BRAND - "+brandName+" PRODUCTS");
    }
}
