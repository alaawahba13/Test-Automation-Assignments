package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginConfirmationPage;
import pages.LoginPage;

public class LoginTest extends BaseTests {
    LoginPage loginPage;

    @BeforeClass
    public void goToLoginPage() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidCredentials() {
        loginPage.typeUsername("student");
        loginPage.typePassword("Password123");
        LoginConfirmationPage loginConfirmationPage = loginPage.clickSubmit();
        String URL = loginConfirmationPage.getURL();
        String title = loginConfirmationPage.getTitle();
        String logoutBtn = loginConfirmationPage.getLogout();
        Assert.assertTrue(URL.contains("practicetestautomation.com/logged-in-successfully/"), "Wrong URL");
        Assert.assertEquals(title, "Logged In Successfully", "Title not found");
        Assert.assertEquals(logoutBtn, "Log out", "Logout button not found");
        loginConfirmationPage.clickLogout();
    }

    @Test
    public void testInvalidUsername() {
        loginPage.typeUsername("incorrectUser");
        loginPage.typePassword("Password123");
        loginPage.clickSubmit();
        String errorMessage = loginPage.getErrorMsg();
        Assert.assertEquals(errorMessage, "Your username is invalid!", "Wrong error message");
    }

    @Test
    public void testInvalidPassword() {
        loginPage.typeUsername("student");
        loginPage.typePassword("incorrectPassword");
        loginPage.clickSubmit();
        String errorMessage = loginPage.getErrorMsg();
        Assert.assertEquals(errorMessage, "Your password is invalid!", "Wrong error message");
    }


}
