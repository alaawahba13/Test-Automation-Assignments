package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    private final WebDriver driver;

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


    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public void typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void selectDateOfBirth(String day, String month, String year){
        Select daysDropDown = new Select(driver.findElement(daysList));
        daysDropDown.selectByVisibleText(day);
        Select monthsDropDown = new Select(driver.findElement(monthsList));
        monthsDropDown.selectByVisibleText(month);
        Select yearsDropDown = new Select(driver.findElement(yearsList));
        yearsDropDown.selectByVisibleText(year);
    }
    public void typeFirstName(String firstNameValue) {
        driver.findElement(firstName).sendKeys(firstNameValue);
    }

    public void typeLastName(String lastNameValue) {
        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void typeAddress(String addressValue) {
        driver.findElement(address).sendKeys(addressValue);
    }

    public void selectCountry(String countryValue) {
        Select countryDropDown = new Select(driver.findElement(country));
        countryDropDown.selectByVisibleText(countryValue);
    }

    public void typeState(String stateValue) {
        driver.findElement(state).sendKeys(stateValue);
    }

    public void typeCity(String cityValue) {
        driver.findElement(city).sendKeys(cityValue);
    }

    public void typeZipcode(String zipcodeValue) {
        driver.findElement(zipcode).sendKeys(zipcodeValue);
    }

    public void typePhoneNumber(String phoneNumberValue) {
        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
    }

    public AccountConfirmationPage clickCreateAccountButton() {
        driver.findElement(createAccountBtn).click();
        return new AccountConfirmationPage(driver);
    }


}
