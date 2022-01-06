package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DELETE_BookingId {

    public static void main(String[] args){

        /**
         * First we need to build the request
         */
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{bookingId}")
                    .pathParam("bookingId", 1)
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .contentType(ContentType.JSON)

        /**
         * Second we need to hit the request and grab the response
         */
                .when()
                    .delete()

        /**
         * Third we need to validate the response
         */
                .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(201);
    }
}
