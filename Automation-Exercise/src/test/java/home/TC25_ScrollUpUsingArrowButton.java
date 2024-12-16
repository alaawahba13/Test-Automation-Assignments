package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC25_ScrollUpUsingArrowButton extends BaseTests {
    @Test
    public void testScrollUpButton() {
        homePage.scrollDown();
        String actualTitle = homePage.getSubscriptionTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains("SUBSCRIPTION"), "Subscription title does not match.");
        homePage.clickScrollUp();
        actualTitle = homePage.getHeaderText();
        Assert.assertEquals(actualTitle, "Full-Fledged practice website for Automation Engineers", "Subscription title does not match.");

    }
}
