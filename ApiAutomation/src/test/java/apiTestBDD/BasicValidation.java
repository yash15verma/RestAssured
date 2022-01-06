package apiTestBDD;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class BasicValidation {

    /**
     * Verifying the status code of the response
     */
    @Test(priority = 1)
    public void verifyStatusCode(){
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 1)
                .when()
                    .get()
                .then()
                    .assertThat().statusCode(200);
    }

    /**
     * Log the response
     */
    @Test(priority = 2)
    public void logResponse(){
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 1)
                .when()
                    .get()
                .then()
                    .log()
                    .all();
    }

    /**
     * Verifying single content in the response body
     */
    @Test(enabled = false)
    public void  verifySingleContent(){
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 1)
                .when()
                    .get()
                .then()
                .body("firstname", equalTo("Sally"));


    }

    /**
     * Verifying multiple content in the response body
     */
    @Test(priority = 4)
    public void  verifyMultipleContent(){
        RestAssured
                .given()
                    .baseUri("https://reqres.in/api/unknown")
                .when()
                    .get()
                .then()
                .assertThat().body("data.name",hasItems("cerulean", "tigerlily", "fuchsia rose"));


    }
}
