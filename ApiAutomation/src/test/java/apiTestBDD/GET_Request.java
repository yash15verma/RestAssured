package apiTestBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.beans.XMLDecoder;

import static org.hamcrest.Matchers.equalTo;

public class GET_Request {

    @Test
    public void getBookingId(){
        /**
         * First we need to build the request
         */
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 3)

        /**
         * Second we need to hit the request
         */
                .when()
                    .get()

        /**
         * Third we need to validate the response
         */
                .then()
                    .log()
                    .all()
                    .assertThat().statusCode(200)
                    .assertThat().statusLine("HTTP/1.1 200 OK");


    }
}
