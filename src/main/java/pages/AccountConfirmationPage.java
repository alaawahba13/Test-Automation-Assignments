package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountConfirmationPage {
    private final WebDriver driver;

    private final By accountCreatedLbl = By.xpath("//h2[@data-qa=\"account-created\"]");
    private final By accountDeletedLbl = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    private final By continueBtn = By.linkText("Continue");

    public AccountConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getDeleteConfirmMsg(){
        return driver.findElement(accountDeletedLbl).getText();
    }

    public HomePage clickContinue(){
        driver.findElement(continueBtn).click();
        return new HomePage(driver);
    }

    public String getAccountCreatedLbl(){
        return driver.findElement(accountCreatedLbl).getText();
    }
}
