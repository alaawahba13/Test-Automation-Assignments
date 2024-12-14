package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends PageBase{

    private final By title = By.cssSelector("[class=\"col-sm-12 text-center\"]");

    private final By facility = By.id("combo_facility");
    private final By applyForReadmission = By.id("chk_hospotal_readmission");
    private final By visitDate = By.id("txt_visit_date");
    private final By bookAppointmentBtn = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver){
        super(driver);
    }
    public String getTitle(){
        return getString(title);
    }
    public void selectFacility(String facilityName){
        Select dropDown = new Select(driver.findElement(facility));
        dropDown.selectByVisibleText(facilityName);
    }
    public void checkReadmission(Boolean isApplied){
       if(isApplied)
           clickElement(applyForReadmission);
    }
    public void selectProgram(String program){
        final By HealthCareProgram = By.id("radio_program_"+program.toLowerCase());
        clickElement(HealthCareProgram);
    }
    public void selectVisitDate(String date){
        sendKeys(visitDate,date);
    }
    public AppointmentConfirmationPage clickBook(){
        clickElement(bookAppointmentBtn);
        return new AppointmentConfirmationPage(driver);
    }

}
