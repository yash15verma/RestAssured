package org.apiAutomation;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class JSONPathWithFilter1 {

    @Test
    public void JSONPathFilter() {

        String jsonFilePath = "/Users/yashverma/RestAssured/src/test/java/org/apiAutomation/people1.json";

        File file = new File(jsonFilePath);

        JsonPath jsonPath = new JsonPath(file);

        System.out.println(jsonPath.getString("data[0].first_name"));

        System.out.println(jsonPath.getList("data.first_name"));

        List<String> allFemaleFirstName =  jsonPath.getList("data.findAll{it.gender=='female'}.first_name");
        System.out.println(allFemaleFirstName);

        System.out.println(jsonPath.getList("data.findAll{it.id>5 | it.last_name=='soni'}.first_name"));


    }

}
