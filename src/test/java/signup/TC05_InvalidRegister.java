package signup;

import base.BaseTests;
import base.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC05_InvalidRegister extends BaseTests {

    @BeforeMethod
    public void goToSignUpPage(){
        loginPage=  homePage.clickLogIn();
    }

    @Test(dataProviderClass = Data.class, dataProvider = "signup")
    public void testInvalidSignUp(String name, String email, String expectedMsg, String type){
        loginPage.typeSignUpName(name);
        loginPage.typeSignUpEmail(email);
        loginPage.clickSignUpBtn();
        String errorMsg = type.equals("tooltip")?loginPage.getSignupToolTipMsg():loginPage.getSignupErrorMsg();
        Assert.assertEquals(errorMsg,expectedMsg, "Error Sign up");
    }

}
