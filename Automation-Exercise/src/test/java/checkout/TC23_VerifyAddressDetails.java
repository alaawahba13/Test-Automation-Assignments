package checkout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.account.SignUpPage;

public class TC23_VerifyAddressDetails extends BaseTests {

    String expectedFirstName = "alaa";
    String expectedLastName = "Wahba";
    String expectedAddress = "Zigo";
    String expectedCountry = "United States";
    String expectedState = "New York";
    String expectedCity ="Brooklyn";
    String expectedZipCode = "4543";
    String expectedPhoneNo = "123456897";
    @BeforeClass
    public void testRegister(){
        loginPage = homePage.clickLogIn();
        loginPage.typeSignUpName("alaa");
        loginPage.typeSignUpEmail("alaawahbaa8@gmail.com");
        SignUpPage signUpPage = loginPage.clickSignUpBtn();
        signUpPage.typePassword("1234567");
        signUpPage.selectDateOfBirth("7","August","2001");
        signUpPage.typeFirstName(expectedFirstName);
        signUpPage.typeLastName(expectedLastName);
        signUpPage.typeAddress(expectedAddress);
        signUpPage.selectCountry(expectedCountry);
        signUpPage.typeState(expectedState);
        signUpPage.typeCity(expectedCity);
        signUpPage.typeZipcode(expectedZipCode);
        signUpPage.typePhoneNumber(expectedPhoneNo);
        confirmationPage = signUpPage.clickCreateAccountButton();
        Assert.assertEquals(confirmationPage.getAccountCreatedLbl(),"ACCOUNT CREATED!","Error creating account");
        homePage = confirmationPage.clickContinue();
        Assert.assertTrue(homePage.getLoggedInLbl().contains("Logged in as"));
    }
    @Test(priority = 1)
    public void testAddProductToCart() {
        popUp = homePage.addItemToCart(0);
        String title = popUp.getPopUpTitle();
        Assert.assertEquals(title, "Added!", "Error adding to cart");
        cartPage = popUp.clickViewCartBtn();
        Assert.assertTrue(cartPage.getPageURL().contains("view_cart"),"Error navigating to cart");
        checkoutPage = cartPage.clickCheckout();
        Assert.assertTrue(checkoutPage.isAddressAndCheckoutDisplayed(),"Error navigating to checkout page");
    }


    @Test(dependsOnMethods = "testAddProductToCart",priority = 2)
    public void VerifyDeliveryAddressDetails(){
        Assert.assertTrue(checkoutPage.getDeliveryFirstLastName().contains(expectedFirstName +" " +expectedLastName), "Delivery First and Last Name doesn't match");
        Assert.assertEquals(checkoutPage.getDeliveryAddress(), expectedAddress, "Delivery Address doesn't match");
        Assert.assertEquals(checkoutPage.getDeliveryCityStatePostCode(), expectedCity+ " "+expectedState+" "+expectedZipCode, "Delivery City/State/Postal Code doesn't match");
        Assert.assertEquals(checkoutPage.getDeliveryCountry(), expectedCountry, "Delivery Country doesn't match");
        Assert.assertEquals(checkoutPage.getDeliveryPhoneNo(), expectedPhoneNo, "Delivery Phone Number doesn't match");
    }

    @Test(dependsOnMethods = "testAddProductToCart",priority = 2)
    public void verifyBillingAddressDetails(){
        Assert.assertTrue(checkoutPage.getBillingFirstLastName().contains(expectedFirstName +" " +expectedLastName), "Billing First and Last Name doesn't match");
        Assert.assertEquals(checkoutPage.getBillingAddress(), expectedAddress, "Billing Address doesn't match");
        Assert.assertEquals(checkoutPage.getBillingCityStatePostCode(), expectedCity+ " "+expectedState+" "+expectedZipCode, "Billing City/State/Postal Code doesn't match");
        Assert.assertEquals(checkoutPage.getBillingCountry(), expectedCountry, "Billing Country doesn't match");
        Assert.assertEquals(checkoutPage.getBillingPhoneNo(), expectedPhoneNo, "Billing Phone Number doesn't match");
    }

    @Test(priority = 4)
    public void testDeleteAccount(){
        confirmationPage = homePage.clickDeleteAccount();
        Assert.assertEquals(confirmationPage.getDeleteConfirmMsg(),"ACCOUNT DELETED!","Error Logging out");
        homePage=  confirmationPage.clickContinue();
    }
}
