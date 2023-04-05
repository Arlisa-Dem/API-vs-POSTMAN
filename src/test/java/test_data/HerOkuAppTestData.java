package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    //This method creates a map for inner json
    public Map<String, String> bookingdatesMapMethod(String checkin, String checkout) {
        Map<String, String> bookingdatesMap = new HashMap<>();

        bookingdatesMap.put("checkin", checkin);
        bookingdatesMap.put("checkout", checkout);

        return bookingdatesMap;
    }

    //This method creates a map for outer json
    public Map<String, Object> expectedDataMethod(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates, String additionalneeds) {
        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdates);
        if (additionalneeds!=null) {
            expectedData.put("additionalneeds", additionalneeds);
        }
        return expectedData;
    }
}