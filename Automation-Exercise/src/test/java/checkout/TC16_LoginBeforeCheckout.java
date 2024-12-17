package checkout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC16_LoginBeforeCheckout extends BaseTests {


    @BeforeClass
    public void testRegister(){
        loginPage = homePage.clickLogIn();
        loginPage.typeLoginEmail("alaawahbaa13@gmail.com");
        loginPage.typeLoginPassword("1234567");
        homePage =  loginPage.clickLoginBtn();
        String loggedInLbl = homePage.getLoggedInLbl();
        System.out.println(loggedInLbl);
        Assert.assertTrue(loggedInLbl.contains("Logged in as "),"Error logging In");
    }

    @Test(priority = 1)
    public void testAddProductToCart() {
        popUp = homePage.addItemToCart(0);
        popUp.clickContinueShopping();
        homePage.addItemToCart(1);
        String title = popUp.getPopUpTitle();
        Assert.assertEquals(title, "Added!", "Error adding to cart");
        cartPage = popUp.clickViewCartBtn();
        Assert.assertTrue(cartPage.getPageURL().contains("view_cart"),"Error navigating to cart");
    }


    @Test(dependsOnMethods = "testAddProductToCart",priority = 2)
    public void checkoutAndPlaceOrder(){
        checkoutPage = cartPage.clickCheckout();
        Assert.assertTrue(checkoutPage.isAddressAndCheckoutDisplayed(),"Error navigating to checkout page");
        checkoutPage.setCommentTxt("This is a comment");
        paymentPage = checkoutPage.clickPlaceOrder();
        paymentPage.setNameOnCard("John Doe");
        paymentPage.setCardNumber("4111111111111111");
        paymentPage.setCVC("123");
        paymentPage.setExpiryMonth("12");
        paymentPage.setExpiryYear("2025");
        confirmationPage = paymentPage.clickConfirmOrder();
        Assert.assertEquals(confirmationPage.getOrderPlacedLbl(),"ORDER PLACED!", "Error in placing order");
    }

//    @Test(priority = 3)
//    public void testDeleteAccount(){
//        confirmationPage = homePage.clickDeleteAccount();
//        Assert.assertEquals(confirmationPage.getDeleteConfirmMsg(),"ACCOUNT DELETED!","Error Logging out");
//        homePage=  confirmationPage.clickContinue();
//    }

}
