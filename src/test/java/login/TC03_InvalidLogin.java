package login;

import base.BaseTests;
import base.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.account.LoginPage;

public class TC03_InvalidLogin extends BaseTests {
    LoginPage loginPage;

    @BeforeClass
    public void goToLoginPage(){
        loginPage = homePage.clickLogIn();
    }

    @BeforeMethod
    public void clearTextBoxes(){
        loginPage.clearLoginFields();
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
