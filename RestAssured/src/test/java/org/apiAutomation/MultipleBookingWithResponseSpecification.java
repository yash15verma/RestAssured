package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleBookingWithResponseSpecification {

    ResponseSpecification responseSpecification;

    @BeforeMethod
    public void configResponseSpecification(){
       responseSpecification =  RestAssured.expect();
       responseSpecification.statusCode(200);
       responseSpecification.contentType(ContentType.JSON);
       responseSpecification.time(Matchers.lessThan(5000L));

    }
    @Test
    public void updateBookingWithPATCHMethod(){

        /**
         * First we need to create the request
         */
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("{path}/{bookingId}")
                    .pathParam("path", "booking")
                    .pathParam("bookingId", 1)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body("{\n" +
                            "    \"firstname\" : \"Shashi\",\n" +
                            "    \"lastname\" : \"Verma\"\n" +
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
                .spec(responseSpecification);
    }

    @Test
    public void updateBookingWithPUTMethod(){
        /**
         * First we need to create the request
         */
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/2")
                    .header("Content-Type", "application/json")
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body("{\n" +
                            "    \"firstname\" : \"James\",\n" +
                            "    \"lastname\" : \"Brown\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2021-06-30\",\n" +
                            "        \"checkout\" : \"2021-07-01\"\n" +
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
                    .spec(responseSpecification);
    }
}
