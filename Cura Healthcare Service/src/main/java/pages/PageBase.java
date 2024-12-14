package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait ;

    public PageBase(){

    }

    public PageBase(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected void clickElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    protected void sendKeys(By element, String input){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        driver.findElement(element).sendKeys(input);
    }

    protected String getString(By element){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
       return driver.findElement(element).getText();
    }

}
