package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PATCH_UpdateBookingId {

    public static void main(String[] args){
        /**
         * First we need to build the request. Here we are updating the booking details by using id.
         */
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{bookingId}")
                    .pathParam("bookingId", 1)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body("{\n" +
                            "    \"firstname\" : \"Yash\",\n" +
                            "    \"lastname\" : \"Brown\"\n" +
                            "}")

        /**
         * Second we need to hit the request and get the response
         */
                .when()
                    .patch()

        /**
         * Third we need to validate the response
         */
                .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(200);

    }
}
