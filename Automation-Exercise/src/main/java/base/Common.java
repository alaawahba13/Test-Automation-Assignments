package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Common {
    protected WebDriver driver;
    protected WebDriverWait wait;
    JavascriptExecutor js;

    public Common() {
    }

    public Common(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
        js = (JavascriptExecutor) driver;
    }

    //========================= Helper methods  ===========================================
    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    protected void setText(By element, String input) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(input);
    }

    protected String getText(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    protected void scrollToText(String text) {
        By elementWithText = By.xpath("//*[contains(text(),'" + text + "')]");
        WebElement element = driver.findElement(elementWithText);

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToTheBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    protected String getTooltipMsg(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", driver.findElement(element));
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }
}
