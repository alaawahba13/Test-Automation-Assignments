package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import base.PageBase;

public class SignUpPage extends PageBase {

    private final By passwordField = By.id("password");
    private final By daysList = By.id("days");
    private final By monthsList = By.id("months");
    private final By yearsList = By.id("years");

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By address = By.id("address1");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By phoneNumber = By.id("mobile_number");
    private final By createAccountBtn = By.xpath("//button[@data-qa=\"create-account\"]");


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void typePassword(String password) {
        setText(passwordField, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        Select daysDropDown = new Select(driver.findElement(daysList));
        daysDropDown.selectByVisibleText(day);
        Select monthsDropDown = new Select(driver.findElement(monthsList));
        monthsDropDown.selectByVisibleText(month);
        Select yearsDropDown = new Select(driver.findElement(yearsList));
        yearsDropDown.selectByVisibleText(year);
    }

    public void typeFirstName(String firstNameValue) {
        setText(firstName, firstNameValue);
    }

    public void typeLastName(String lastNameValue) {
        setText(lastName, lastNameValue);
    }

    public void typeAddress(String addressValue) {
        setText(address, addressValue);
    }

    public void selectCountry(String countryValue) {
        new Select(driver.findElement(country)).selectByVisibleText(countryValue);
    }

    public void typeState(String stateValue) {
        setText(state, stateValue);
    }

    public void typeCity(String cityValue) {
        setText(city, cityValue);
    }

    public void typeZipcode(String zipcodeValue) {
        setText(zipcode, zipcodeValue);
    }

    public void typePhoneNumber(String phoneNumberValue) {
        setText(phoneNumber, phoneNumberValue);
    }

    public AccountConfirmationPage clickCreateAccountButton() {
        clickElement(createAccountBtn);
        return new AccountConfirmationPage(driver);
    }


}
