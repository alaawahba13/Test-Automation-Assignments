package home;

import base.BaseTests;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.AccountConfirmationPage;
import pages.LoginPage;

public class HomeTests extends BaseTests {
    LoginPage loginPage;

    @Test(dependsOnMethods = "testValidCredentials")
    public void testLogout(){
        loginPage = homePage.clickLogOut();
        Assert.assertTrue(loginPage.getURL().contains("login"),"Error Logging out");
    }
    @Test
    public void testDeleteAccount(){
        AccountConfirmationPage accountDeletedPage = homePage.clickDeleteAccount();
        Assert.assertEquals(accountDeletedPage.getDeleteConfirmMsg(),"ACCOUNT DELETED!","Error Logging out");
        homePage=  accountDeletedPage.clickContinue();
    }
}
