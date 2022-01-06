package org.apiAutomation;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathIntro {

    @Test
    public  void jsonPathDemo(){

        String json ="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        //Get json path instance of given json doc

        JsonPath jsonPath = new JsonPath(json);
        System.out.println(jsonPath.getString("lastname"));
        System.out.println(jsonPath.getInt("totalprice"));
        System.out.println(jsonPath.getBoolean("depositpaid"));


    }
}
