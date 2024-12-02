package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountConfirmationPage;
import pages.LoginPage;

public class LoginTest extends BaseTests {
    LoginPage loginPage;

    @BeforeClass
    public void goToLoginPage(){
        loginPage = homePage.clickLogIn();
    }

    @BeforeMethod
    public void clearTextBoxes(){
        loginPage.clearLoginFields();
    }

    @Test
    public void testValidCredentialsWithLogout(){
        loginPage.typeLoginEmail("alaawahba13@gmail.com");
        loginPage.typeLoginPassword("1234567");
        loginPage.clickLoginBtn();
        String loggedInLbl = homePage.getLoggedInLbl();
        System.out.println(loggedInLbl);
        Assert.assertTrue(loggedInLbl.contains("Logged in as "),"Error logging In");
        loginPage = homePage.clickLogOut();
        Assert.assertTrue(loginPage.getURL().contains("login"),"Error Logging out");
    }
    @Test
    public void testValidCredentialsWithDeleteAccount(){
        loginPage.typeLoginEmail("alaawahba13@gmail.com");
        loginPage.typeLoginPassword("1234567");
        loginPage.clickLoginBtn();
        String loggedInLbl = homePage.getLoggedInLbl();
        System.out.println(loggedInLbl);
        Assert.assertTrue(loggedInLbl.contains("Logged in as "),"Error logging In");
        AccountConfirmationPage accountDeletedPage = homePage.clickDeleteAccount();
        Assert.assertEquals(accountDeletedPage.getDeleteConfirmMsg(),"ACCOUNT DELETED!","Error Logging out");
        homePage=  accountDeletedPage.clickContinue();
        goToLoginPage();
    }

    @Test
    public void testEmptyCredentials(){
        loginPage.typeLoginEmail("");
        loginPage.typeLoginPassword("");
        loginPage.clickLoginBtn();
        String errorMsg = loginPage.getLoginToolTipMsg();
        System.out.println(errorMsg);
        Assert.assertEquals(errorMsg,"Please fill out this field.","Error logging In");
    }


    @Test
    public void testWrongPassword(){
        loginPage.typeLoginEmail("alaawahbaa13@gmail.com");
        loginPage.typeLoginPassword("45");
        loginPage.clickLoginBtn();
        String errorMsg = loginPage.getLoginErrorMsg();
        System.out.println(errorMsg);
        Assert.assertEquals(errorMsg,"Your email or password is incorrect!","Error logging In");
    }

    @Test
    public void testWrongEmailDomain(){
        loginPage.typeLoginEmail("alaawahbaa13@gmail");
        loginPage.typeLoginPassword("1234567");
        loginPage.clickLoginBtn();
        String errorMsg = loginPage.getLoginErrorMsg();
        System.out.println(errorMsg);
        Assert.assertEquals(errorMsg,"Your email or password is incorrect!","Error logging In");
    }

    @Test
    public void testWrongEmailFormat(){
        loginPage.typeLoginEmail("alaawahbaa13gmail.com");
        loginPage.typeLoginPassword("1234567");
        loginPage.clickLoginBtn();
        String errorMsg = loginPage.getLoginToolTipMsg();
        System.out.println(errorMsg);
        Assert.assertTrue(errorMsg.contains("Please include an '@' in the email address."),"Error logging In");
    }



}
