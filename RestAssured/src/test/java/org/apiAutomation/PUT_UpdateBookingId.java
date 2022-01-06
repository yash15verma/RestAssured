package org.apiAutomation;

import io.restassured.RestAssured;

public class PUT_UpdateBookingId {

    public static void main(String[] args){

        /**
         * First we have to build the request. Here we are updating the information based on booking id by using the PUT method
         */
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("{path}/{bookingId}")
                    .pathParam("path","booking")
                    .pathParam("bookingId",1)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body("{\n" +
                            "    \"firstname\" : \"Yash\",\n" +
                            "    \"lastname\" : \"Verma\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2018-01-01\",\n" +
                            "        \"checkout\" : \"2019-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Breakfast\"\n" +
                            "}")


        /**
         * Second we need to hit the request and get the response
         */
                .when()
                    .put()

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
