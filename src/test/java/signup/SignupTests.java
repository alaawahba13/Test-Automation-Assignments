package signup;

import base.BaseTests;
import base.Data;
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
        loginPage.typeSignUpEmail("alaawahba5@gmail.com");
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

    @Test(dataProviderClass = Data.class, dataProvider = "signup")
    public void testInvalidSignUp(String name, String email, String expectedMsg, String type){
        loginPage.typeSignUpName(name);
        loginPage.typeSignUpEmail(email);
        loginPage.clickSignUpBtn();
        String errorMsg = type.equals("tooltip")?loginPage.getSignupToolTipMsg():loginPage.getSignupErrorMsg();
        Assert.assertEquals(errorMsg,expectedMsg, "Error Sign up");
    }

}
