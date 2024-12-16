package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_ContactUsForm extends BaseTests {
    
    @Test(priority = 1)
    public void goToContactUsPage(){
       contactUsPage =  homePage.clickContactUs();
        Assert.assertTrue(contactUsPage.isGetInTouchDisplayed(), "Title is not displayed.");
    }
    
    @Test(priority = 2)
    public void testContactUs() {
        contactUsPage.enterName("John Doe");
        contactUsPage.enterEmail("johndoe@example.com");
        contactUsPage.enterSubject("Test Subject");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.uploadFile("C:\\Users\\Qebaa\\Documents\\IntelliJ\\Automation-Exercise\\src\\main\\resources\\contactUsFile.txt"); // Replace with a valid file path
        contactUsPage.clickSubmit();

        contactUsPage.acceptAlert();
        Assert.assertEquals(contactUsPage.getSuccessMessage(),"Success! Your details have been submitted successfully.", "Success alert is not displayed.");
       homePage= contactUsPage.clickHomeButton();
        Assert.assertEquals(homePage.getProductsTitle(),"FEATURES ITEMS","Error Navigating to home page");
    }

}
