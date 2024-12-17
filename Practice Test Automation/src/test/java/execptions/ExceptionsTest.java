package execptions;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ExceptionsPage;

public class ExceptionsTest extends BaseTests {
    ExceptionsPage exceptionsPage;
    @BeforeMethod
    public void goToExceptions(){
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        exceptionsPage = new ExceptionsPage(driver);
    }

    @Test
    public void TC01_testNoSuchElementException(){
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRow2Displayed());
    }

    @Test
    public void TC02_testElementNotInteractableException(){
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRow2Displayed());
        exceptionsPage.enterTextInRow2Input("test");
        exceptionsPage.clickSaveButton();
        Assert.assertEquals(exceptionsPage.getConfirmationMsg(),"Row 2 was saved.");
    }

    @Test
    public void TC03_testInvalidElementStateException(){
        exceptionsPage.clickEditButton();
        exceptionsPage.clearTextRow1();
        exceptionsPage.enterTextInRow1Input("text");
        exceptionsPage.clickSaveButton();
        Assert.assertEquals(exceptionsPage.getConfirmationMsg(),"Row 1 was saved");
    }

    @Test
    public void TC04_testStaleElementReferenceException(){
        WebElement instructions = exceptionsPage.getInstructionElement();

        exceptionsPage.clickAddButton();
       Assert.assertFalse(instructions.isDisplayed());
    }

    @Test
    public void TC05_TimeoutException(){
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRow2Displayed());
    }
}
