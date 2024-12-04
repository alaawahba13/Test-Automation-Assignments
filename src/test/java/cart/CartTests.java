package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CartPage;




public class CartTests extends BaseTests {

    CartPage cartPage;

    public void verifyAddToCart(String itemTitle, String itemPrice, String itemQuantity){
        String title = homePage.getPopUpTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Added!","Error adding to cart");

        cartPage=homePage.clickViewCartBtn();
        Assert.assertTrue(cartPage.getItemsTitle().contains(itemTitle),"Wrong item title");
        Assert.assertTrue(cartPage.getItemsPrice().contains(itemPrice),"Wrong item price");
        Assert.assertTrue(cartPage.getItemsQuantity().contains(itemQuantity),"Wrong item quantity");
    }

    @Test
    public void goToCartPage(){
        cartPage = homePage.clickCart();
        Assert.assertTrue( cartPage.getURL().contains("view_cart"), "Error navigating to cart");
    }

    @Test(dependsOnMethods = "goToCartPage")
    @Parameters("index")
    public void testDeleteCartItem(int index){
        String title = cartPage.getItemsTitle().get(index);
        cartPage.removeCartItem(index);
        Assert.assertFalse(cartPage.getItemsTitle().contains(title),"Error removing item from cart");
    }

    @Test(dependsOnMethods = "goToCartPage")
    public void testEmptyCart(){
        cartPage.emptyCart();
        Assert.assertEquals(cartPage.getEmptyCartText(),"Cart is empty! Click here to buy products.","Error emptying cart");
    }

}
