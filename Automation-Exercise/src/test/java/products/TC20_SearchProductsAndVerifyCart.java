package products;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC20_SearchProductsAndVerifyCart extends BaseTests {
    private final ArrayList<String> titles = new ArrayList<>();
    private final ArrayList<String> prices = new ArrayList<>();
    int size;

    @Test(priority = 1)
    public void viewProducts() {
        productsPage = homePage.clickProducts();
        String title = productsPage.getProductsTitle();
        Assert.assertEquals(title, "ALL PRODUCTS");

    }

    @Test(dependsOnMethods = "viewProducts")
    public void testSearchForItem() {
        productsPage.searchItem("dress");
        String title = productsPage.getProductsTitle();
        Assert.assertEquals(title, "SEARCHED PRODUCTS", "Error searching");
        size = productsPage.getNumberOfItems();
        Assert.assertTrue(size > 1);
    }

    @Test(dependsOnMethods = "testSearchForItem")
    public void addSearchedProductsToCart() {
        for (int i = 0; i < size; i++) {
            titles.add(homePage.getItemTitle(i));
            prices.add(homePage.getItemPrice(i));
            popUp = homePage.addItemToCart(i);
            if (i == size - 1) {
                cartPage =popUp.clickViewCartBtn();
            } else {
                popUp.clickContinueShopping();
            }
        }
    }

    @Test(dependsOnMethods = "addSearchedProductsToCart")
    public void verifyItemsInCart() {
        for(int i =0 ; i<size ;i++){
            Assert.assertTrue(cartPage.getItemsTitle().contains(titles.get(i)), "Wrong item title");
            Assert.assertTrue(cartPage.getItemsPrice().contains(prices.get(i)), "Wrong item price");
        }
    }
    @Test(dependsOnMethods = "verifyItemsInCart")
    public void testValidLogin(){
        loginPage = cartPage.clickLogIn();
        loginPage.typeLoginEmail("alaawahbaa13@gmail.com");
        loginPage.typeLoginPassword("1234567");
        homePage =  loginPage.clickLoginBtn();
        String loggedInLbl = homePage.getLoggedInLbl();
        System.out.println(loggedInLbl);
        Assert.assertTrue(loggedInLbl.contains("Logged in as "),"Error logging In");
    }
    @Test(dependsOnMethods = "testValidLogin")
    public void verifyItemsInCartAfterLogin() {
       cartPage = homePage.clickCart();
        for(int i =0 ; i<size ;i++){
            Assert.assertTrue(cartPage.getItemsTitle().contains(titles.get(i)), "Wrong item title");
            Assert.assertTrue(cartPage.getItemsPrice().contains(prices.get(i)), "Wrong item price");
        }
    }
}
