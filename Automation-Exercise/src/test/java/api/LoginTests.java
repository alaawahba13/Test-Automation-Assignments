package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class LoginTests extends APIBaseTest{
    Response response;

    @Test
    public void TC07_postValidLogin(){
       response = given().
                spec(requestSpec).
                formParam("email","alaawahbaa13@gmail.com").
                formParam("password","1234567").
                when().
                post("verifyLogin");
        assertEquals(getStatusCode(response), 200, "Expected response code is not matched");
        assertEquals(getMessage(response),   "User exists!");
    }

    @Test
    public void TC08_postLoginWithoutEmail(){
        response = given().
                spec(requestSpec).
                formParam("password","1234567").
                when().
                post("verifyLogin");
        assertEquals(getStatusCode(response), 400, "Expected response code is not matched");
        assertEquals(getMessage(response),    "Bad request, email or password parameter is missing in POST request.");

    }

    @Test
    public void TC09_deleteLogin(){
       response =  given().
                spec(requestSpec).
                formParam("email","alaawahbaa13@gmail.com").
                formParam("password","1234567").
                when().
                delete("verifyLogin");
        assertEquals(getStatusCode(response), 405, "Expected response code is not matched");
        assertEquals(getMessage(response),    "This request method is not supported.");

    }
    @Test
    public void TC010_postInvalidLogin(){
       response= given().
                spec(requestSpec).
                formParam("email","alaa@gmail.com").
                formParam("password","12567").
                when().
                post("verifyLogin");
        assertEquals(getStatusCode(response), 404, "Expected response code is not matched");
        assertEquals(getMessage(response),    "User not found!");

    }

}
