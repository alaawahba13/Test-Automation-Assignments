package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExceptionsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By addBtn = By.id("add_btn");
    private final By editBtn = By.id("edit_btn");
    private final By saveBtn = By.id("save_btn");
    private final By row1Input = By.cssSelector("#row1 .input-field");
    private final By row2Input = By.cssSelector("#row2 .input-field");
    private final By confirmationTxt = By.id("confirmation");
    private final By instructions = By.id("instructions");

    public ExceptionsPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickAddButton() {
        driver.findElement(addBtn).click();
    }

    public void clickEditButton() {
        driver.findElement(editBtn).click();
    }

    public void clickSaveButton() {
        driver.findElement(saveBtn).click();
    }



    public boolean isRow2Displayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(row2Input));
        return driver.findElement(row2Input).isDisplayed();
    }
    public void enterTextInRow2Input(String text) {
        driver.findElement(row2Input).sendKeys(text);
    }
    public void enterTextInRow1Input(String text) {
        driver.findElement(row1Input).sendKeys(text);
    }
    public void clearTextRow1() {
        driver.findElement(row1Input).clear();
    }

    public String getConfirmationMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationTxt));
        return driver.findElement(confirmationTxt).getText();
    }

    public WebElement getInstructionElement(){
        return driver.findElement(instructions);
    }



}
