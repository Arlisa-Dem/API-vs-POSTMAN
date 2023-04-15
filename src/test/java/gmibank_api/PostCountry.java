package gmibank_api;

import base_url.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.States;
import utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostCountry extends GmiBankBaseUrl {
    /*
    //Type an automation test that creates a "country" which includes at least 3 "states" using
     the document //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1.

Given
     https://www.gmibank.com/api/tp-countries

And
{

  "name": "My Country",
  "states": [
       {
      "id": 1,
      "name": "Koln"

    },
    {
      "id": 2,
      "name": "Solingen"

    },
    {
      "id": 3,
      "name": "Benrath"

    }
  ]
}
When
    Send post request
Then
    Status code should be 201
And
   Response body should be like :

    {
    "id": 181991,
    "name": "My Country",
    "states": [
        {
            "id": 1,
            "name": "Koln",
            "tpcountry": null
        },
        {
            "id": 2,
            "name": "Solingen",
            "tpcountry": null
        },
        {
            "id": 3,
            "name": "Benrath",
            "tpcountry": null
        }
    ]
}
     */



    @Test
    public void PostCountry(){

        //Set the url
        spec.pathParams("first","api","second","tp-countries");

        //Set the expected data
        States state1 = new States(1,"Koln");
        States state2 = new States(2,"Solingen");
        States state3 = new States(3,"Benrath");

        List<States> stateList = new ArrayList<>();
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);

        Country expectedData = new Country("My Country",stateList);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response

        Response response = given(spec).body(expectedData).post("{first}/{second}");
        //response.prettyPrint();

        //Do assertion
        Country actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(), Country.class);
        System.out.println("actualData = " + actualData);


        assertEquals(201,response.statusCode());

        assertEquals(expectedData.getName(),actualData.getName());



    }
}