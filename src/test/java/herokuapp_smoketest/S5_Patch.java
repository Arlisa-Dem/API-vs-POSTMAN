package herokuapp_smoketest;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S5_Patch extends HerOkuAppBaseUrl {
    /*
    given
         https://restful-booker.herokuapp.com/booking/{id}

    And
            {
    "firstname" : "Arlisa",
    "lastname" : "Demiraj"
}

    When
        Send Patch request
    Then
        Status code 200
    And
           {
    "firstname": "Arlisa",
    "lastname": "Demiraj",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2023-01-01",
        "checkout": "2024-01-01"
    },
    "additionalneeds": "Iftar Time"
}




     */

@Test
    public void patchTest(){

    //Set the url
    spec.pathParams("first","booking","second",bookingId);

    //Set the expected data
    Map<String,String> expectedData = new HashMap<>();
    expectedData.put("firstname","Arlisa");
    expectedData.put("lastname","Demiraj");

    //Send the request and get the response
   Response response =  given(spec).body(expectedData).patch("{first}/{second}");
   response.prettyPrint();

   //Do assertion
    Map<String,Object> actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),HashMap.class);
    System.out.println("actualData = " + actualData);

    assertEquals(200,response.statusCode());
    assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
    assertEquals(expectedData.get("lastname"), actualData.get("lastname"));

}

}
