package org.apiAutomation;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateSimpleJsonObjectUsingMap {

  @Test
    public void withSAmeDataType(){

      Map<String, String> jsonObjectPayload =  new HashMap<>();
      jsonObjectPayload.put("first_name", "Yash");
      jsonObjectPayload.put("last_name", "Verma");
      jsonObjectPayload.put("salary", "123.55");
      jsonObjectPayload.put("age", "28");
      jsonObjectPayload.put("married", "false");

      RestAssured
              .given()
                .log()
                .all()
                .body(jsonObjectPayload)
              .when()
                .get()
              .then()
                .log()
              .all();

  }

    @Test
    public void withDifferentDataType(){

        Map<String, Object> jsonObjectPayload =  new HashMap<>();
        jsonObjectPayload.put("first_name", "Yash");
        jsonObjectPayload.put("last_name", "Verma");
        jsonObjectPayload.put("salary", 123.55);
        jsonObjectPayload.put("age", 28);
        jsonObjectPayload.put("married", false);

        RestAssured
                .given()
                    .log()
                    .all()
                    .body(jsonObjectPayload)
                .when()
                    .get()
                .then()
                    .log()
                    .all();

    }

    @Test
    public void withDifferentDataType_LinkedHashMap_ProperSeries(){

        Map<String, Object> jsonObjectPayload =  new LinkedHashMap<>();
        jsonObjectPayload.put("first_name", "Yash");
        jsonObjectPayload.put("last_name", "Verma");
        jsonObjectPayload.put("salary", 123.55);
        jsonObjectPayload.put("age", 28);
        jsonObjectPayload.put("married", false);

        RestAssured
                .given()
                .log()
                .all()
                .body(jsonObjectPayload)
                .when()
                .get()
                .then()
                .log()
                .all();

    }


}
