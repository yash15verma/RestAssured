package apiTestBDD;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DELETE_Request {

    @Test
    public  void deleteBookingId(){
        /**
         * First we need to build the request
         */
        String str =RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 5)
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")

        /**
         * Second we need to hit the request
         */
                .when()
                    .delete()

        /**
         * Third we need to validate the response
         */
                .then()
                .log()
                .all().extract().response().asPrettyString();
                System.out.println("Response - "+str);
    }
}
