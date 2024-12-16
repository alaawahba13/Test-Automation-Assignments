package pages.common;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends PageBase {
    private final By title = By.cssSelector(".contact-form h2");
    private final By nameTxt = By.name("name");
    private final By emailTxt = By.name("email");
    private final By subjectTxt = By.name("subject");
    private final By messageTxt = By.name("message");
    private final By uploadFileBtn = By.name("upload_file");
    private final By submitBtn = By.name("submit");
    private final By alertMessage = By.cssSelector("[class=\"status alert alert-success\"]");
    private final By homeBtn = By.linkText("Home");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGetInTouchDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public void enterName(String name) {
        setText(nameTxt, name);
    }

    public void enterEmail(String email) {
        setText(emailTxt, email);
    }

    public void enterSubject(String subject) {
        setText(subjectTxt, subject);
    }

    public void enterMessage(String message) {
        setText(messageTxt, message);
    }

    public void uploadFile(String filePath) {
        setText(uploadFileBtn, filePath);
    }

    public void clickSubmit() {
        clickElement(submitBtn);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getSuccessMessage() {
        return getText(alertMessage);
    }

    public HomePage clickHomeButton() {
        clickElement(homeBtn);
        return new HomePage(driver);
    }



}
