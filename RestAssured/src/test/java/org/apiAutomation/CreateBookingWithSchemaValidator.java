package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;


public class CreateBookingWithSchemaValidator {

    @Test
    public void createBooking(){
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
                    .contentType(ContentType.JSON)

                .when()
                    .post()

                .then()
                    .log()
                    .all()
                    .body(JsonSchemaValidator
                            .matchesJsonSchema(new File("/Users/yashverma/RestAssured/src/test/java/org/apiAutomation/JSON_Schema.json")));


    }
}
