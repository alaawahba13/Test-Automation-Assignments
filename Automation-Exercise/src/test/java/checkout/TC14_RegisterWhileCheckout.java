package checkout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.account.SignUpPage;
import pages.common.PopUp;

public class TC14_RegisterWhileCheckout extends BaseTests {


    @BeforeClass
    public void testAddProductToCart() {
        popUp = homePage.addItemToCart(0);
        popUp.clickContinueShopping();
        homePage.addItemToCart(1);
        String title = popUp.getPopUpTitle();
        Assert.assertEquals(title, "Added!", "Error adding to cart");
        cartPage = popUp.clickViewCartBtn();
        Assert.assertTrue(cartPage.getPageURL().contains("view_cart"),"Error navigating to cart");
    }

    @Test(priority = 1)
    public void clickCheckout(){
        cartPage.clickCheckout();
        popUp = new PopUp(driver);
       loginPage = popUp.clickLoginAndRegister();
    }

    @Test(dependsOnMethods ="clickCheckout", priority = 2)
    public void testRegister(){
        loginPage.typeSignUpName("alaa");
        loginPage.typeSignUpEmail("alaawahbaa8@gmail.com");
        SignUpPage signUpPage = loginPage.clickSignUpBtn();
        signUpPage.typePassword("1234567");
        signUpPage.selectDateOfBirth("7","August","2001");
        signUpPage.typeFirstName("alaa");
        signUpPage.typeLastName("wahba");
        signUpPage.typeAddress("zigo");
        signUpPage.selectCountry("United States");
        signUpPage.typeState("New York");
        signUpPage.typeCity("Brooklyn");
        signUpPage.typeZipcode("4543");
        signUpPage.typePhoneNumber("123456897");
         confirmationPage = signUpPage.clickCreateAccountButton();
        Assert.assertEquals(confirmationPage.getAccountCreatedLbl(),"ACCOUNT CREATED!","Error creating account");
        homePage = confirmationPage.clickContinue();
        Assert.assertTrue(homePage.getLoggedInLbl().contains("Logged in as"));
    }


    @Test(dependsOnMethods = "testRegister",priority = 3)
    public void checkoutAfterRegister(){
        cartPage = homePage.clickCart();
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

    @Test(priority = 4)
    public void testDeleteAccount(){
        confirmationPage = homePage.clickDeleteAccount();
        Assert.assertEquals(confirmationPage.getDeleteConfirmMsg(),"ACCOUNT DELETED!","Error Logging out");
        homePage=  confirmationPage.clickContinue();
    }





}
