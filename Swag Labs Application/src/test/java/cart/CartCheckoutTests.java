package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartCheckoutTests extends BaseTests {

    private String expectedPrice;
    private String expectedTitle;

    @Test(description =
            "1- Login with Application and to get credentials by\n" +
            " scrolling down into the application and get text for\n" +
            " username and password and then Login with\n" +
            " (standard_user)"+
            " 2- Check the user is login successfully",
            priority = 1
    )
    public void testLogin() {
        loginPage.autoFillCredentials("standard_user");
        productsPage = loginPage.clickLoginBtn();
        Assert.assertTrue(productsPage.isPageHeaderPresent(),"Error Loggin in");
    }


    @Test(description =
            " 3- Add the first Product into cart\n" +
            " 4-Go to cart and check the product into Item",
            priority = 2
    )
    public void testAddFirstItemToCart() {
         expectedPrice = productsPage.getProductPrice(0);
         expectedTitle = productsPage.getProductTitle(0);
        productsPage.clickAddToCart(0);
        cartPage = productsPage.goToCart();
        Assert.assertEquals(cartPage.getProductTitle(0),expectedTitle,"Wrong Title in cart");
        Assert.assertEquals(cartPage.getProductPrice(0),expectedPrice,"Wrong price in cart");
    }

    @Test(description =
            "5-Click on checkout"+
            "6-Filling the form of checkout and click on continue button" ,
            priority = 3
    )
    public void fillCheckoutInfo(){
        checkoutPage = cartPage.clickCheckout();
        checkoutPage.typeFirstName("Alaa");
        checkoutPage.typeLastName("Wahba");
        checkoutPage.typeZipCode("055");
        checkoutPage.clickContinue();
    }
    @Test(description =
            " 7-Check the checkout review page by checking the product details and price" +
            "8- Click finish" +
            " 9- check the message of “Thank you for you order” ",
            priority = 4
    )
    public void reviewOrder(){

        Assert.assertEquals(checkoutPage.getProductTitle(0),expectedTitle,"Wrong Title in checkout");
        Assert.assertEquals(checkoutPage.getProductPrice(0),expectedPrice,"Wrong price in checkout");
        checkoutPage.clickFinish();
        Assert.assertEquals(checkoutPage.getCompleteTitle(),"THANK YOU FOR YOU ORDER","Error completing checkout");

    }


}
