package org.apiAutomation;

import io.restassured.RestAssured;

public class ExtractResponseBodyAsString {

    public static void main(String[] args) {

        /**
         * First we need to build the request
         */
        String responseBody = RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking")
                    .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
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

                /**
                 * Second we need to hit the request and get the response as a string
                 */
                .when()
                    .post()

                .then()
                    .extract()
                    .asPrettyString();
        System.out.println(responseBody);


    }
}
