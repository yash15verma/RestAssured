package org.apiAutomation;

import io.restassured.RestAssured;

public class GET_BookingId {

    public static void main(String[] args){

        /**
         * First we need to Build the request
         */
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 1)

        /**
         * Second we need to Hit the request and get the response
         */
                .when()
                    .get()
        /**
         * Third we need to Validate the response
         */
                 .then()
                    .log()
                    .all()
                    .statusCode(200);
    }
}
