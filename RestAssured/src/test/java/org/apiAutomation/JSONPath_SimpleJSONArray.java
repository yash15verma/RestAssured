package org.apiAutomation;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

public class JSONPath_SimpleJSONArray {

    @Test(enabled = false)
    public void writeJSONPathForSimpleJSONArray(){

        String JSONArray = "[\n" +
                "  \"10\",\n" +
                "  \"20\",\n" +
                "  \"30\",\n" +
                "  \"40\",\n" +
                "  \"50\"\n" +
                "]";

        JsonPath jsonPath = new JsonPath(JSONArray);
        /**
         * Getting the value of 0th index.
         */
        System.out.println(jsonPath.getString("[0]"));

        /**
         * Getting the object from the root node
         */
        System.out.println(jsonPath.getList("$"));

        /**
         * Getting the size of the list
         */
        System.out.println(jsonPath.getList("$").size());
    }

    @Test
    public void writeJSONPathForMultipleSimpleJSONArray(){

        String JSONArray ="[\n" +
                "  [\n" +
                "    \"10\",\n" +
                "    \"20\",\n" +
                "    \"30\",\n" +
                "    \"40\",\n" +
                "    \"50\"\n" +
                "  ],\n" +
                "  [\n" +
                "    \"60\",\n" +
                "    \"70\",\n" +
                "    \"80\",\n" +
                "    \"90\",\n" +
                "    \"100\",\n" +
                "    \"110\"\n" +
                "  ]\n" +
                "]";

        JsonPath jsonPath = new JsonPath(JSONArray);
        //Value of Oth json index
        System.out.println(jsonPath.getString("[0]"));

        //Value of 1st Json index
        System.out.println(jsonPath.getString("[1]"));

        //Fetching value of 3rd index from 1st Json index
        System.out.println(jsonPath.getString("[1][3]"));

        //Size of the list
        System.out.println(jsonPath.getList("$").size());

        //size of 1st index list
        List<Object> internalList = (List<Object>) jsonPath.getList("$").get(1);
        System.out.println(internalList.size());

    }
}
