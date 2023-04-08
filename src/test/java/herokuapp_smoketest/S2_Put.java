package herokuapp_smoketest;

import org.junit.Test;

public class S2_Put {


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

        //Set the expected data

        //Set the request and get the response

        //Do assertion




    }





}
