package signup;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.account.ConfirmationPage;
import pages.account.SignUpPage;

public class TC01_RegisterUser extends BaseTests {


    @BeforeClass
    public void goToSignUpPage(){
        loginPage=  homePage.clickLogIn();
    }

    @Test(priority = 1)
    public void testValidSignUp(){
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

    @Test(priority = 2)
    public void testDeleteAccount(){
         confirmationPage = homePage.clickDeleteAccount();
        Assert.assertEquals(confirmationPage.getDeleteConfirmMsg(),"ACCOUNT DELETED!","Error Logging out");
        homePage=  confirmationPage.clickContinue();
    }
}
