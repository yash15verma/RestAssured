package org.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class WithOrWithOutInlineAssertion {

    @Test(enabled = false)
    public void withOutInlineAssertion(){

        String jsonResponse = RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/auth")
                    .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .when()
                    .post()
                .then()
                    .log()
                    .all()
                .extract()
                .asPrettyString();

        //System.out.println("Response - "+jsonResponse);

        JsonPath jsonPath = new JsonPath(jsonResponse);
        System.out.println(jsonPath.getString("token"));
    }

    @Test
    public void withInlineAssertion(){
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/auth")
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .when()
                    .post()
                .then()
                    .log()
                    .all()
                .body("token", Matchers.notNullValue())
                .body("token", Matchers.hasLength(15))
                .body("token.length()", Matchers.equalTo(15));
    }
}
