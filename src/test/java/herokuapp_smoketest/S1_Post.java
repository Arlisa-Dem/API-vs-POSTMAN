package herokuapp_smoketest;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S1_Post extends HerOkuAppBaseUrl {
    /*
Using the document "https://restful-booker.herokuapp.com/apidoc/index.html";
Type an automation test that creates a booking, updates that booking and then deletes it.
 Add positive and negative tests that validate these steps.
*/

    /*
    Given
         https://restful-booker.herokuapp.com/booking

    And
       {

        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }

      When
          Send post request
      Then
          Status code should be 200
      And
         Response body should be response
         {
    "bookingid": 5768,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}


     */




    @Test
    public void postTest(){

        //Set the url
        spec.pathParam("first","booking");

        //Set te expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim","Brown",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();


        //Do assertion
        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

        //With convertJsonToJavaObject() we handled throw exception issue

        assertEquals(200,response.statusCode());

        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());


    }

}
