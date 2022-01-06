package org.apiAutomation;

import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

public class GET_NamedParameters_ByUsingMap {

    public static void main(String[] args){

        /**
         * Here we are using HashMap when we having number of path parameters.
         */
        Map<String, Object> pathParameters = new HashMap<>();
        pathParameters.put("path", "booking");
        pathParameters.put("bookingId", 1);

        /**
         * First we need to build the request
         */
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("{path}/{bookingId}")
                    .pathParams(pathParameters)

                /**
                 * Second we need to hit the request and get the response
                 */
                .when()
                    .get()

                /**
                 * Third we need to validate the response
                 */
                .then()
                    .log()
                    .all()
                    .statusCode(200);



    }
}
