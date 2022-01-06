package apiTestBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PUT_Request {

    HashMap map = new HashMap();

    /**
     * First we need to collect the data which we need to update
     */
    @BeforeClass
    public void putData(){

        map.put("firstname", RestUtils.getFirstName());
        map.put("lastname", RestUtils.getLastName());
        map.put("totalprice", RestUtils.getTotalPrice());

    }

    @Test
    public void updateBookingId(){
        /**
         * First we need to build the request
         */
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{id}")
                .pathParam("id", 3)
                .body("{\n" +
                        "    \"firstname\" : \"Deepak\",\n" +
                        "    \"lastname\" : \"Sharma\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
        /**
         * Second we need to hit the request
         */
                .when()
                    .put()
        /**
         * Third we need to validate the response
         */
                .then()
                .log().all();
    }
}
