package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.PageBase;
import pages.common.HomePage;

public class AccountConfirmationPage extends PageBase {


    private final By accountCreatedLbl = By.xpath("//h2[@data-qa=\"account-created\"]");
    private final By accountDeletedLbl = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    private final By continueBtn = By.linkText("Continue");

    public AccountConfirmationPage(WebDriver driver){
       super(driver);
    }

    public String getDeleteConfirmMsg(){
        return getText(accountDeletedLbl);
    }

    public HomePage clickContinue(){
        clickElement(continueBtn);
        return new HomePage(driver);
    }

    public String getAccountCreatedLbl(){
        return getText(accountCreatedLbl);
    }
}
