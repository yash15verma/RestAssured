package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleBookingWithRequestSpecification {

    RequestSpecification requestSpecification;

    @BeforeMethod
    public void configRequestSpec() {
        requestSpecification = RestAssured.given();
        requestSpecification
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType(ContentType.JSON);
    }

    @Test
    public void createBooking() {
        RestAssured
                .given()
                .spec(requestSpecification)
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
                .when()
                .post()
                .then()
                .log()
                .all()
                .statusCode(200);

    }

    @Test
    public void updateBooking() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .basePath("booking/1")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body("{\n" +
                        "        \"firstname\": \"Tim\",\n" +
                        "        \"lastname\": \"Crook\",\n" +
                        "        \"totalprice\": 111,\n" +
                        "        \"depositpaid\": true,\n" +
                        "        \"bookingdates\": {\n" +
                        "            \"checkin\": \"2018-01-01\",\n" +
                        "            \"checkout\": \"2019-01-01\"\n" +
                        "        },\n" +
                        "        \"additionalneeds\": \"Breakfast\"\n" +
                        "    }")
                .when()
                .put()
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}

