package signup;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.account.AccountConfirmationPage;
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
        AccountConfirmationPage accountConfirmationPage = signUpPage.clickCreateAccountButton();
        Assert.assertEquals(accountConfirmationPage.getAccountCreatedLbl(),"ACCOUNT CREATED!","Error creating account");
        homePage = accountConfirmationPage.clickContinue();
        Assert.assertTrue(homePage.getLoggedInLbl().contains("Logged in as"));
    }

    @Test(priority = 2)
    public void testDeleteAccount(){
        AccountConfirmationPage accountDeletedPage = homePage.clickDeleteAccount();
        Assert.assertEquals(accountDeletedPage.getDeleteConfirmMsg(),"ACCOUNT DELETED!","Error Logging out");
        homePage=  accountDeletedPage.clickContinue();
    }
}
