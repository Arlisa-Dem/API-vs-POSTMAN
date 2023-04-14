package practice;


import base_url.HomeWorkBaseUrl;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.Country;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;

public class HomeWork  {


    /*
    //Type an automation test that creates a "country" which includes at least 3 "states" using
     the document //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1.
     */

    @Test
    public void createCountryTest(){

        RestAssured.baseURI = "https://localhost:8080/api";

        // Create a JSON object for the country with at least 3 states
        JSONObject country = new JSONObject();
        country.put("name", "Test Country");
        country.put("states", new String[]{"State 1", "State 2", "State 3"});

        // Send a POST request to create the country with states
        Response response = given()
                .contentType(ContentType.JSON)
                .body(country)
                .post("/countries");

        // Verify that the response has a success status code (e.g. 200)
        response.then().statusCode(200);

        // Print the response body for debugging purposes
        System.out.println(response.body().asString());
    }
}
