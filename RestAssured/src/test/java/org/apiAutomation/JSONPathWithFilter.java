package org.apiAutomation;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class JSONPathWithFilter {

    @Test
    public void JSONPathFilter() {

        String jsonFilePath = "/Users/yashverma/RestAssured/src/test/java/org/apiAutomation/people.json";

        File file = new File(jsonFilePath);

        JsonPath jsonPath = new JsonPath(file);

        System.out.println(jsonPath.getString("[0].first_name"));

        System.out.println(jsonPath.getList("first_name"));

        List<String> allFemaleFirstName =  jsonPath.getList("findAll{it.gender=='female'}.first_name");
        System.out.println(allFemaleFirstName);

        List<String> allPersonName = jsonPath.getList("findAll{it.last_name=='soni'}.email");
        System.out.println(allPersonName);

        List<String> firstName = jsonPath.getList("findAll{it.gender=='female' & it.last_name=='soni'}.first_name");
        System.out.println(firstName);

        //System.out.println(jsonPath.getList("find{it.gender=='female'}.first_name")); //java.lang.ClassCastException: java.lang.String cannot be cast to java.util.List


    }

}
