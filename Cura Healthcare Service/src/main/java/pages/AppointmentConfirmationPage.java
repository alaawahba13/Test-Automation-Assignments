package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage extends PageBase {

    private final By title = By.xpath("//div[@class=\"col-xs-12 text-center\"]//h2");
    private final By facility = By.id("facility");
    private final By hospitalReadmission = By.id("hospital_readmission");
    private final By program = By.id("program");
    private final By visitDate = By.id("visit_date");

    public AppointmentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getString(title);
    }

    public String getFacility() {
        return getString(facility);
    }

    public boolean getHospitalReadmission() {
        return getString(hospitalReadmission).equals("Yes");
    }

    public String getProgram() {
        return getString(program);
    }

    public String getVisitDate() {
        return getString(visitDate);
    }


}
