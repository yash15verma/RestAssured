package org.apiAutomation.pathParameters;

import io.restassured.RestAssured;

public class NamedParameter {
    public static void main(String[] args){

        /**
         * First we need to build the request
         */
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("{path}/{bookingId}")
                    .log().all()
                    .pathParam("path", "booking") //This is named parameter
                    .pathParam("bookingId", 1) //This is named parameter
        /**
         * Second we need to hit the request and get the response
         */
                .when()
                    .get()

        /**
         * Third we need to validate the response
         */
                .then()
                .log().all()
                .statusCode(200);
    }
}
