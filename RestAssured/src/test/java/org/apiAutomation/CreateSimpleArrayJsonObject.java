package org.apiAutomation;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreateSimpleArrayJsonObject {

    @Test
    public void withSingleArrayData(){
        Map<String, Object> emp1JsonPayload = new LinkedHashMap<>();
        emp1JsonPayload.put("id", 22);
        emp1JsonPayload.put("firstname", "Yash");
        emp1JsonPayload.put("lastname", "Verma");
        emp1JsonPayload.put("salary", 28972);
        emp1JsonPayload.put("Designation", "Senior Software Engineer");

        List<Map<String, Object>> allList =  new ArrayList<>();
        allList.add(emp1JsonPayload);

        RestAssured
                .given()
                    .log()
                    .all()
                    .body(allList)
                .when()
                    .get()
                .then()
                    .log()
                    .all();
    }

    @Test
    public void withMultipleArrayData(){
        Map<String, Object> emp1JsonPayload = new LinkedHashMap<>();
        emp1JsonPayload.put("id", 22);
        emp1JsonPayload.put("firstname", "Yash");
        emp1JsonPayload.put("lastname", "Verma");
        emp1JsonPayload.put("salary", 28972);
        emp1JsonPayload.put("Designation", "Senior Software Engineer");

        Map<String, Object> emp2JsonPayload = new LinkedHashMap<>();
        emp2JsonPayload.put("id", 233);
        emp2JsonPayload.put("firstname", "Honey");
        emp2JsonPayload.put("lastname", "Verma");
        emp2JsonPayload.put("salary", 289372);
        emp2JsonPayload.put("Designation", "Software Engineer");

        List<Map<String, Object>> allList =  new ArrayList<>();
        allList.add(emp1JsonPayload);
        allList.add(emp2JsonPayload);

        RestAssured
                .given()
                    .log()
                    .all()
                    .body(allList)
                .when()
                    .get()
                .then()
                    .log()
                    .all();
    }
}
