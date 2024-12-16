package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.TestCasesPage;

public class TC07_VerifyTestCasesPage extends BaseTests {
    @Test
    public void goToTestCasesPage(){
       TestCasesPage testCasesPage = homePage.clickTestCases();
        Assert.assertTrue(testCasesPage.getPageURL().contains("test_cases"),"Erro navigating to test cases page");
    }
}
