package signup;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountConfirmationPage;
import pages.LoginPage;
import pages.SignUpPage;

public class SignupTests extends BaseTests {

    LoginPage loginPage;

    @BeforeClass
    public void goToSignUpPage(){
      loginPage=  homePage.clickLogIn();
    }

    @Test
    public void testValidSignUp(){
        loginPage.typeSignUpName("alaa");
        loginPage.typeSignUpEmail("alaawahba13@gmail.com");
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

    @Test
    public void testEmptyFields(){
        loginPage.typeSignUpName("");
        loginPage.typeSignUpEmail("");
        loginPage.clickSignUpBtn();
        String errorMsg = loginPage.getSignupToolTipMsg();
        Assert.assertEquals(errorMsg,"Please fill out this field.", "Error Sign up");
    }

    @Test
    public void testExistingEmail(){
        loginPage.typeSignUpName("alaa");
        loginPage.typeSignUpEmail("alaawahbaa13@gmail.com");
        loginPage.clickSignUpBtn();
        String errorMsg = loginPage.getSignupErrorMsg();
        Assert.assertEquals(errorMsg,"Email Address already exist!", "Error Sign up");
    }

}
