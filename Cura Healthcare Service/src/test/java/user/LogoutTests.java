package user;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTests {

    @Test
    public void clickLogout(){
        homePage.clickLogout();
        Assert.assertEquals(homePage.getURL(),"https://katalon-demo-cura.herokuapp.com/","Error Logout");
    }

}
