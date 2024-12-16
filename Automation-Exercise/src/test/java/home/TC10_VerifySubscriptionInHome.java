package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_VerifySubscriptionInHome extends BaseTests {

    @Test
    public void testSuccessfulSubscriptionInHome() {
        homePage.scrollDown();
        String actualTitle = homePage.getSubscriptionTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains("SUBSCRIPTION"), "Subscription title does not match.");

        homePage.enterSubscribeEmail("test@example.com");
        homePage.clickSubscribeButton();

        String expectedMessage = "You have been successfully subscribed!";
        String actualMessage = homePage.getSubscribeSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Subscription success message does not match.");


    }
}
