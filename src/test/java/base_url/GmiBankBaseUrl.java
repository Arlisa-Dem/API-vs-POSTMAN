package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationGmiBank.gmiBankToken;

public class GmiBankBaseUrl {

    protected RequestSpecification spec;

    @Before//This will run before each test method
    public void setUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization","Bearer "+gmiBankToken()).
    setBaseUri("https://www.gmibank.com").build();

    }

}
