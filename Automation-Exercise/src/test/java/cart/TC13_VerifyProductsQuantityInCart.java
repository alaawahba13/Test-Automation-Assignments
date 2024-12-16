package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC13_VerifyProductsQuantityInCart extends BaseTests {



    @Test(priority = 1)
    @Parameters("index")
    public void testViewProductButton(@Optional("1") int index){
        viewProductPage = homePage.clickViewProduct(index);
        String url = viewProductPage.getPageURL();
        Assert.assertTrue(url.contains("product_details"),"Error Navigating to product page");

        viewProductPage.setItemQuantity("4");
        popUp=  viewProductPage.clickAddToCart();
        cartPage = popUp.clickViewCartBtn();
        Assert.assertTrue(cartPage.getItemsQuantity().contains("4"),"Wrong item quantity");
    }
}
