package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.testng.Assert.assertEquals;

public class UserAccountTests extends APIBaseTest {

    Response response;

    @Test(priority = 1)
    public void TC11_postCreateAccount() {
        response =  given().
                spec(requestSpec)
                .formParam("email", "johnemad1@gmail.com")
                .formParam("password", "password123")
                .formParam("title", "Mr")
                .formParam("birth_date", "10")
                .formParam("birth_month", "January")
                .formParam("birth_year", "1990")
                .formParam("firstname", "John")
                .formParam("lastname", "Doe")
                .formParam("company", "ExampleCorp")
                .formParam("address1", "123 Example Street")
                .formParam("address2", "Apartment 456")
                .formParam("country", "United States")
                .formParam("zipcode", "12345")
                .formParam("state", "California")
                .formParam("city", "Los Angeles")
                .formParam("mobile_number", "1234567890")
                .formParam("name", "JohnDoe")
                .when()
                .post("createAccount");

        assertEquals(getStatusCode(response), 201, "Expected response code is not matched");
        assertEquals(getMessage(response), "User created!");


    }

    @Test(dependsOnMethods = "TC11_postCreateAccount",priority = 3)
    public void TC12_deleteAccount() {
        response = given().
                spec(requestSpec)
                .formParam("email", "johnemad1@gmail.com")
                .formParam("password", "password123")
                .when()
                .delete("deleteAccount");

        assertEquals(getStatusCode(response), 200, "Expected response code is not matched");
        assertEquals(getMessage(response), "Account deleted!");

    }

    @Test(dependsOnMethods = "TC11_postCreateAccount",priority = 2)
    public void TC13_putUpdateccount() {
        response = given().
                spec(requestSpec)
                .formParam("email","johnemad1@gmail.com")
                .formParam("password","password123")
                .formParam("name", "Alaa Wahba")
                .formParam("birth_year", "1980")
                .when()
                .put("updateAccount");
        assertEquals(getStatusCode(response), 200, "Expected response code is not matched");
        assertEquals(getMessage(response), "User updated!");


    }

    @Test(priority = 4)
    public void TC14_getUserDetails() {
        given().
                spec(requestSpec)
                .formParam("email", "alaawahbaa13@gmail.com")
                .when()
                .post("getUserDetailByEmail")
                .then()
                .spec(responseSpec)
                .body("user.size()", greaterThan(0));


    }

}
