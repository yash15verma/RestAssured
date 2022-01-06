package org.apiAutomation;

import io.restassured.RestAssured;

public class GET_Named_UnNamedParameter {
    public static void main(String[] args){

        /**
         * First we need to build the request
         */
        RestAssured
                .given()
                    .log()
                    .all()
                    .pathParam("path", "booking")

        /**
         * Second we need to hit the request and get the response
         * This is the combination of "Named Parameter" & "UnNamed Parameter"
         * In this way whatever the parameter we mentioned in "pathParam" method will take first and rest of the left parameters will take from "In-line" parameter based on sequence.
         */
                .when()
                    .get("https://restful-booker.herokuapp.com/{path}/{bookingId}", 1)

        /**
         * Third we need to validate the status
         */
                .then()
                    .log()
                    .all()
                    .statusCode(200);

    }
}
