package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11_VerifySubscriptionInCart extends BaseTests {

    @BeforeClass
    public void goToCart(){
        cartPage =homePage.clickCart();
    }

    @Test
    public void testSuccessfulSubscriptionInCart() {
        cartPage.scrollDown();
        String actualTitle = cartPage.getSubscriptionTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains("SUBSCRIPTION"), "Subscription title does not match.");

        cartPage.enterSubscribeEmail("test@example.com");
        cartPage.clickSubscribeButton();

        String expectedMessage = "You have been successfully subscribed!";
        String actualMessage = cartPage.getSubscribeSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Subscription success message does not match.");


    }

}
