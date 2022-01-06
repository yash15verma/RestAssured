package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POST_CreateBookingWithRequestAndResponseSpecification {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setupRequestAndResponseSpecification() {
        requestSpecification = RestAssured.given()
        .log().all()
        .baseUri("https://restful-booker.herokuapp.com/")
        .header("Content-Type","application/json");

        responseSpecification = RestAssured.expect()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .time(Matchers.lessThan(4000L));
    }

    @Test
    public void createBooking(){
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
                    .spec(responseSpecification);


    }
}
