package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public PageBase() {
    }

    public PageBase(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    protected void setText(By element, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(text);
    }

    protected String getText(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    protected void scrollToTextAndClick(String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))")));

        element.click();
    }

    protected void scrollUp() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true)).scrollBackward()"));
    }

}
