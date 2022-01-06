package org.apiAutomation;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreateNestedJsonObjectUsingMap {

    @Test
    public void withDifferentDataType(){

        Map<String, Object> jsonPayload = new LinkedHashMap<>();
        jsonPayload.put("id", 22);
        jsonPayload.put("firstname", "Yash");
        jsonPayload.put("lastname", "Verma");
        jsonPayload.put("salary", 28972);
        jsonPayload.put("Designation", "Senior Software Engineer");

        /**
         * Another mapping for address
         */
        Map<String, Object> jsonPayloadAddress = new LinkedHashMap<>();
        jsonPayloadAddress.put("House No", "RZK-94A");
        jsonPayloadAddress.put("Street No", 2);
        jsonPayloadAddress.put("City", "New Roshanpura, Najafgarh");
        jsonPayloadAddress.put("State", "Delhi");
        jsonPayload.put("Address", jsonPayloadAddress);
        jsonPayload.put("Contact No", 9958914882L);

        RestAssured
                .given()
                    .log()
                    .all()
                    .body(jsonPayload)
                .when()
                    .get()
                .then()
                    .log()
                    .all();

    }
}
