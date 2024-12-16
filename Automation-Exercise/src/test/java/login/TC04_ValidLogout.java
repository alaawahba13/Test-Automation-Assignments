package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC04_ValidLogout extends BaseTests {
    @BeforeClass
    public void goToLoginPage(){
        loginPage = homePage.clickLogIn();
    }
    @Test
    public void testValidCredentials(){
        loginPage.typeLoginEmail("alaawahbaa13@gmail.com");
        loginPage.typeLoginPassword("1234567");
        homePage =  loginPage.clickLoginBtn();
        String loggedInLbl = homePage.getLoggedInLbl();
        System.out.println(loggedInLbl);
        Assert.assertTrue(loggedInLbl.contains("Logged in as "),"Error logging In");
    }
    @Test(dependsOnMethods = "testValidCredentials")
    public void testLogout(){
        loginPage = homePage.clickLogOut();
        Assert.assertTrue(loginPage.getPageURL().contains("login"),"Error Logging out");
    }

}
