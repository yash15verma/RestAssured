package org.apiAutomation;

import io.restassured.RestAssured;

public class GET_UnNamedParameter {
    public static void main(String[] args){

        /**
         * First we need to build the request
         */
        RestAssured
                .given()
                    .log()
                    .all()

        /**
         * Second we need to hit the request and get the response
         * This is Un-named parameter or In-line parameter
         * In this URI Parameters, the methods which we mentioned in get method will works based index (works in sequence)
         */
                .when()
                    .get("https://restful-booker.herokuapp.com/{path}/{bookingId}", "booking", 2)

        /**
         * Third we need to validate the response
         */
                .then()
                .log()
                .all()
                .statusCode(200);

    }
}
