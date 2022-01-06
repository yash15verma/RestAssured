package org.apiAutomation;

import io.restassured.RestAssured;

public class POST_CreateBooking {

    public static void main(String[] args){

        /**
         * First we need to create the request
         */
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    .body("{\n" +
                            "    \"firstname\" : \"Jimmy\",\n" +
                            "    \"lastname\" : \"Brown\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2018-01-01\",\n" +
                            "        \"checkout\" : \"2019-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Breakfast\"\n" +
                            "}")
                    .header("Content-Type", "application/json")

                .when()
                    .post()

                .then()
                    .log()
                    .all()
                    .statusCode(200);
    }
}
