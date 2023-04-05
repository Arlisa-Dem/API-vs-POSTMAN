package practice_dt;

import base_url.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Q02 extends RegresBaseUrl {
/*
    Given
            1) https://reqres.in/api/users
            2) {
        "name": "morpheus",
                "job": "leader"
    }
    When
    I send POST Request to the Url
            Then
    Status code is 201
    And response body should be like {
        "name": "morpheus",
                "job": "leader",
                "id": "496",
                "createdAt": "2022-10-04T15:18:56.372Z"
    }
     */

    @Test
    public void post(){

        spec.pathParams("first","api","second","users");

        Map<String,String> expectedData= new HashMap<>();

        expectedData.put("name","morpheus");
        expectedData.put("job","leader");
        System.out.println("expectedData = " + expectedData);

        //post
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();


        Map<String, String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        //check status code 201

        Assert.assertEquals(201,response.getStatusCode());
        Assert.assertEquals(expectedData.get("name"),actualData.get("name"));
        Assert.assertEquals(expectedData.get("job"),actualData.get("job"));


    }


}
