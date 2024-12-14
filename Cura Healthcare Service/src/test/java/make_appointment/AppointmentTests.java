package make_appointment;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentTests extends BaseTests {


    @Test(dependsOnMethods = "testValidCredentials")
    public void makeAppointment() {
        final String facilityName = "Hongkong CURA Healthcare Center";
        final boolean isApplied = true;
        final String program = "Medicaid";
        final String visitDate = "15/12/2024";
        appointmentPage.selectFacility(facilityName);
        appointmentPage.checkReadmission(isApplied);
        appointmentPage.selectProgram(program);
        appointmentPage.selectVisitDate(visitDate);
        appointmentConfirmationPage = appointmentPage.clickBook();
        Assert.assertEquals(appointmentConfirmationPage.getTitle(), "Appointment Confirmation", "Error Booking");
        Assert.assertEquals(appointmentConfirmationPage.getFacility(), facilityName, "Wrong Facility Name");
        Assert.assertEquals(appointmentConfirmationPage.getHospitalReadmission(), isApplied, "Wrong Hospital Readmission");
        Assert.assertEquals(appointmentConfirmationPage.getProgram(), program, "Wrong program Name");
        Assert.assertEquals(appointmentConfirmationPage.getVisitDate(), visitDate, "Wrong date");

    }

}
