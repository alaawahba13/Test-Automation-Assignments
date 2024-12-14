package user;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {


    @BeforeClass
    public void goToLoginPage() {
        loginPage = homePage.clickLogin();
    }

    @Test
    public void testValidCredentials() {
        loginPage.typeUsername("John Doe");
        loginPage.typePassword("ThisIsNotAPassword");
        appointmentPage = loginPage.clickLogin();
       String actualTitle = appointmentPage.getTitle();
        Assert.assertEquals(actualTitle,"Make Appointment","Error Logging ");

    }



}
