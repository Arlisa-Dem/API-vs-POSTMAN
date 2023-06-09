package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;//Import...--> another way
import org.junit.Before;

public class PetStoreBaseUrl {

    protected RequestSpecification spec;

    @Before//This will run before each test method
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

    }

}
