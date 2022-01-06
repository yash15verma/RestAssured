package apiTestBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class POST_Request {

     HashMap map = new HashMap();//For storing value inside this map

    /**
     * First we need to create a method through which data will be formed
     */
    @BeforeTest
    public void postData() {
        map.put("name", RestUtils.getName());


    }

    @Test
    public void createBookingId(){
        /**
         * Need to build the request
         */
        RestAssured
                .given()
                .baseUri("https://reqres.in/api/users")
                .body(map)

                .contentType(ContentType.JSON)

        /**
         * Need to hit the request
         */
                .when()
                    .post()

        /**
         * Validate the response
         */
                .then()
                    .log()
                    .all()
                .assertThat().statusCode(201)
                .assertThat().statusLine("HTTP/1.1 201 Created")
                .assertThat().contentType(ContentType.JSON);
    }
}
