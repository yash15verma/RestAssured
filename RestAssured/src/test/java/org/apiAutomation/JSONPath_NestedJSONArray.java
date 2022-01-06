package org.apiAutomation;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JSONPath_NestedJSONArray {

    @Test
    public void writeJSONPathForNestedJSONArray(){
        String JsonPath = "[\n" +
                "  {\n" +
                "    \"firstname\": \"yash\",\n" +
                "    \"lastname\": \"verma\",\n" +
                "    \"age\": 29,\n" +
                "    \"address\": [\n" +
                "      {\n" +
                "        \"city\": \"delhi\",\n" +
                "        \"country\": \"india\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"city\": \"mumbai\",\n" +
                "        \"country\": \"india\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        JsonPath jsonPath = new JsonPath(JsonPath);

        System.out.println(jsonPath.getString("firstname"));
        System.out.println(jsonPath.getString("lastname"));
        System.out.println(jsonPath.getString("age"));
        System.out.println(jsonPath.getString("address"));
        System.out.println(jsonPath.getList("address.city"));
        System.out.println(jsonPath.getString("address[0]"));
       // System.out.println(jsonPath.getString("address[0]"));
        //System.out.println(jsonPath.getString("address[0].city"));
        //System.out.println(jsonPath.getString("address.city[0]"));
        //System.out.println(jsonPath.getString("address[0].city[0]"));



    }

    @Test(enabled = false)
    public void writeJSONPathForMultipleNestedJSONArray(){
        String path = "[\n" +
                "  {\n" +
                "    \"firstname\": \"yash\",\n" +
                "    \"lastname\": \"verma\",\n" +
                "    \"age\": 29,\n" +
                "    \"address\": [\n" +
                "      {\n" +
                "        \"city\": \"delhi\",\n" +
                "        \"country\": \"india\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"city\": \"mumbai\",\n" +
                "        \"country\": \"india\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstname\": \"honey\",\n" +
                "    \"lastname\": \"verma\",\n" +
                "    \"age\": 30,\n" +
                "    \"address\": [\n" +
                "      {\n" +
                "        \"city\": \"punjab\",\n" +
                "        \"country\": \"india\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"city\": \"bihar\",\n" +
                "        \"country\": \"india\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        JsonPath jsonPath = new JsonPath(path);

        System.out.println(jsonPath.getString("$"));
        System.out.println(jsonPath.getString("[0]"));
        System.out.println(jsonPath.getString("[0].firstname"));
        System.out.println(jsonPath.getString("[0].lastname"));
        System.out.println(jsonPath.getString("[0].age"));
        System.out.println(jsonPath.getString("[0].address"));
        System.out.println(jsonPath.getString("[0].address[0]"));
        System.out.println(jsonPath.getString("[0].address[0].city"));




        }
}
