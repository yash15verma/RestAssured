package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MeasuringResponseTime {

    @Test
    public void deleteBookingId() {

        /**
         * First we need to build the request
         * Third we need to save the response in a variable
         */
        Response response = RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{bookingId}")
                .pathParam("bookingId", 3)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)

                /**
                 * Second we need to hit the request and get the response
                 */
                .when()
                .delete();

        /**
         * Now we need to get the response time
         */
        long responseTimeInMilliSecond = response.time();
        System.out.println("Response Time : " + responseTimeInMilliSecond + "ms");

        long responseTimeInSecond = response.timeIn(TimeUnit.SECONDS);
        System.out.print("Response Time : " + responseTimeInSecond + "s");

        response.then().time(Matchers.lessThan(5000L));
       // response.then().statusCode(Matchers.equalTo(201));


    }
}
