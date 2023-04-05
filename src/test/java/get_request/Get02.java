package get_request;

import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class Get02 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02(){


        String url = " https://restful-booker.herokuapp.com/booking/0 ";

        Response response = given().when().get(url);
        response.prettyPrint();

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertEquals("Not Found",response.asString());

        assertFalse(response.asString().contains("TechProEd"));


        assertTrue(response.header("Server").contains("Cowboy"));
    }

}
