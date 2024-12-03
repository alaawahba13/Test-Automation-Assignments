package login;

import base.BaseTests;
import base.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTests {
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
    public void testValidCredentials(){
        loginPage.typeLoginEmail("alaawahba7@gmail.com");
        loginPage.typeLoginPassword("1234567");
        homePage =  loginPage.clickLoginBtn();
        String loggedInLbl = homePage.getLoggedInLbl();
        System.out.println(loggedInLbl);
        Assert.assertTrue(loggedInLbl.contains("Logged in as "),"Error logging In");
    }

    @Test( dataProviderClass = Data.class,dataProvider = "login")
    public void testInvalidCredentials(String email, String password, String expectedMsg, String type){
        loginPage.typeLoginEmail(email);
        loginPage.typeLoginPassword(password);
        loginPage.clickLoginBtn();
        String errorMsg = type.equals("tooltip")? loginPage.getLoginToolTipMsg():loginPage.getLoginErrorMsg();
        System.out.println(errorMsg);
        Assert.assertTrue(errorMsg.contains(expectedMsg),"Error logging In");
    }


}
