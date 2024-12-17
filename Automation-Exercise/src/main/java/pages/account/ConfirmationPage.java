package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.PageBase;
import pages.common.HomePage;

public class ConfirmationPage extends PageBase {


    private final By accountCreatedLbl = By.xpath("//h2[@data-qa=\"account-created\"]");
    private final By accountDeletedLbl = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    private final By orderPlacedLbl = By.xpath("//h2[@data-qa=\"order-placed\"]");
    private final By continueBtn = By.linkText("Continue");
    private final By downloadInoviceBtn = By.linkText("Download Invoice");

    public ConfirmationPage(WebDriver driver){
       super(driver);
    }

    public String getDeleteConfirmMsg(){
        return getText(accountDeletedLbl);
    }

    public String getAccountCreatedLbl(){
        return getText(accountCreatedLbl);
    }

    public String getOrderPlacedLbl(){
        return getText(orderPlacedLbl);
    }

    public HomePage clickContinue(){
        clickElement(continueBtn);
        return new HomePage(driver);
    }
    public void clickDownloadInvoice(){
        clickElement(downloadInoviceBtn);
    }

}
