package products;

import base.BaseTests;
import base.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18_ViewCategoryProducts extends BaseTests {

    @Test( dataProviderClass = Data.class, dataProvider = "category")
    public void testFilterByCategory( String gender, String itemCategory){
        productsPage =  homePage.filterByGenderCategory(gender, itemCategory);
        String title = productsPage.getProductsTitle();
        Assert.assertEquals(title,gender.toUpperCase()+" - "+itemCategory.toUpperCase()+" PRODUCTS");
    }
}
