package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC12_AddProductsInCart extends BaseTests {

    private final ArrayList<String> titles = new ArrayList<>();
    private final ArrayList<String> prices = new ArrayList<>();
    private final ArrayList<String> quantities = new ArrayList<>();

    @BeforeClass
    public void viewProducts() {
        productsPage = homePage.clickProducts();
    }

    @Test(priority = 1)
    public void testAddMultipleItemsToCart() {

        titles.add(homePage.getItemTitle(0));
        prices.add(homePage.getItemPrice(0));
        quantities.add("1");
        popUp = homePage.addItemToCart(0);
        popUp.clickContinueShopping();

        titles.add(homePage.getItemTitle(1));
        prices.add(homePage.getItemPrice(1));
        quantities.add("1");
        homePage.addItemToCart(1);
        String title = popUp.getPopUpTitle();
        Assert.assertEquals(title, "Added!", "Error adding to cart");
    }

    @Test(priority = 2)
    public void verifyItemsInCart() {

        cartPage = popUp.clickViewCartBtn();
        for(int i =0 ; i<2 ;i++){
            Assert.assertTrue(cartPage.getItemsTitle().contains(titles.get(i)), "Wrong item title");
            Assert.assertTrue(cartPage.getItemsPrice().contains(prices.get(i)), "Wrong item price");
            Assert.assertTrue(cartPage.getItemsQuantity().contains(quantities.get(i)), "Wrong item quantity");

        }

    }
}
