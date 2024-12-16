package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC17_RemoveProductsFromCart extends BaseTests {

    @Test(priority = 1)
    public void testAddMultipleItemsToCart() {

        popUp = homePage.addItemToCart(0);
        homePage= popUp.clickContinueShopping();
        homePage.addItemToCart(1);

        String title = popUp.getPopUpTitle();
        Assert.assertEquals(title, "Added!", "Error adding to cart");

        popUp.clickContinueShopping();

    }

    @Test(priority = 2 , dependsOnMethods ="testAddMultipleItemsToCart")
    public void goToCartPage(){
        cartPage = homePage.clickCart();
        Assert.assertTrue( cartPage.getPageURL().contains("view_cart"), "Error navigating to cart");
    }

    @Test(dependsOnMethods = "goToCartPage")
    @Parameters("index")
    public void testDeleteCartItem(@Optional("1") int index){
        String title = cartPage.getItemsTitle().get(index);
        cartPage.removeCartItem(index);
        Assert.assertFalse(cartPage.getItemsTitle().contains(title),"Error removing item from cart");
    }

}
