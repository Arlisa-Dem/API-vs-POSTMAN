package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get12 extends GoRestBaseUrl {

/*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        "Marut Nambeesan DC", "Ms. Ankal Sinha", "Chaturbhuj Adiga" are among the users
    And
        The female users are less than or equals to male users
*/


    @Test
    public void get12(){

        //Set the url
        spec.pathParam("first","users");

        //Set the expected data

        //Send the request and get the response

        Response response = given(spec).get("{first}");
        response.prettyPrint();


        //Do assertion
        response.
                then().
                statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",
                        equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),"data.status",hasItem("active"),
                        "data.name",hasItems("Marut Nambeesan DC", "Ms. Ankal Sinha", "Chaturbhuj Adiga"));




    }


}
