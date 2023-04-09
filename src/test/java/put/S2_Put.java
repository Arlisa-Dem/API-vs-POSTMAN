package put;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S2_Put extends HerOkuAppBaseUrl {


    /*

    Given
         https://restful-booker.herokuapp.com/booking/{1}

   And
      {
    "firstname": "Arlisa",
    "lastname": "Demiraj",
    "totalprice": 9797,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Hungry"
}
When
    Send put request

 Then
     Status code should be 200
 And
    Body should be :
    {
    "firstname": "Arlisa",
    "lastname": "Demiraj",
    "totalprice": 9797,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Hungry"
}

     */



    @Test
    public void putTest(){

        //set the url
        spec.pathParams("first","booking","second",1);


        //Set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Arlisa","Demiraj",9797,false,bookingDatesPojo,"Hungry");
        System.out.println("expectedData = " + expectedData);


        //Set the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);


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
