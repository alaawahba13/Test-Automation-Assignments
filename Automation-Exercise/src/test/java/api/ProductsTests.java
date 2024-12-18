package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;


public class ProductsTests extends APIBaseTest {

    Response response;

    @Test
    public void TC01_GetAllProductsList() {
        given().
                spec(requestSpec).
                when().
                get("productsList").
                then().
                spec(responseSpec).
                and().
                body("products.size()", greaterThan(0));

    }

    @Test
    public void TC02_PostAllProductsList() {
       response =  given().
                spec(requestSpec).
                when().
                post("productsList");

        assertEquals(getStatusCode(response), 405, "Expected response code is not matched");
        assertEquals(getMessage(response), "This request method is not supported.");

    }

    @Test
    public void TC03_getAllBrandsList(){
        given().
                spec(requestSpec).
                when().
                get("brandsList").
                then().
                spec(responseSpec).
                and().
                body("brands.size()", greaterThan(0));
    }

    @Test
    public void TC04_putAllBrandsList(){
        response = given().
                spec(requestSpec).
                when().
                put("brandsList");
        assertEquals(getStatusCode(response), 405, "Expected response code is not matched");
        assertEquals(getMessage(response), "This request method is not supported.");

    }

    @Test
    public void TC05_postSearchProduct(){
        given().
                spec(requestSpec).
                formParam("search_product","top").
                when().
                post("searchProduct").
                then().
                spec(responseSpec).
                body("products.size()", greaterThan(0));
    }

    @Test
    public void TC06_postSearchProductWithoutParam(){
       response= given().
                spec(requestSpec).
                when().
                post("searchProduct");
        assertEquals(getStatusCode(response), 400, "Expected response code is not matched");
        assertEquals(getMessage(response), "Bad request, search_product parameter is missing in POST request.");

    }
}
