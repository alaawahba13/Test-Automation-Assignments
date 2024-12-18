package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

public class APIBaseTest {

   protected static RequestSpecification requestSpec;
   protected static ResponseSpecification responseSpec;


    @BeforeClass
    public void setUp(){

        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://automationexercise.com/api/").build();

        responseSpec = new ResponseSpecBuilder().
                            expectStatusCode(200).
                            expectContentType(ContentType.HTML).build();

    }


    protected int getStatusCode(Response response){
        String htmlResponse = response.asString();
        JSONObject jsonResponse = new JSONObject(htmlResponse);

       return  jsonResponse.getInt("responseCode");
    }

    protected String getMessage(Response response){
        String htmlResponse = response.asString();
        JSONObject jsonResponse = new JSONObject(htmlResponse);
        return jsonResponse.getString("message");
    }



}
