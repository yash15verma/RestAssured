package org.apiAutomation;

import io.restassured.RestAssured;

import java.lang.reflect.Array;
import java.util.*;

public class CreateComplexJsonObjectUsingMap {

    public static void main(String[] args){

        //Parent JSON Array
        List<Map<String, Object>> finalPayload = new ArrayList<Map<String, Object>>();

        /**
         *      "id": 1,
         *     "first_name": "Claire",
         *     "last_name": "Dennerley",
         *     "email": "cdennerley@uol.com.br",
         *     "gender": "female",
         */
        Map<String, Object> firstJsonObject = new LinkedHashMap<>();
        firstJsonObject.put("id", 1);
        firstJsonObject.put("first_name", "Claire");
        firstJsonObject.put("last_name", "Dennerley");
        firstJsonObject.put("email", "cdennerley@uol.com.br");
        firstJsonObject.put("gender", "male");

        /**
         *"mobile": [
         *       "1234567890",
         *       "6574389731"
         *     ]
         */
        List<String> mobileNumber = new ArrayList<String>();
        mobileNumber.add("1234567890");
        mobileNumber.add("6574389731");

        /**
         * Performing above action in single line
         */

        List<String> mobileNumber1 = Arrays.asList("1234567890","6574389731");

        firstJsonObject.put("mobile", mobileNumber1);

        /**
         * Map for skills
         * "skills": {
         *       "name": "Testing",
         *       "proficiency": "Meidum"
         *     }
         */
        Map<String, Object> skillSet = new LinkedHashMap<String, Object>();
        skillSet.put("name","Testing");
        skillSet.put("proficiency","Medium");

        firstJsonObject.put("skills", skillSet);

        finalPayload.add(firstJsonObject);

        Map<String, Object> secondJsonObject = new LinkedHashMap<>();
        secondJsonObject.put("id", 1);
        secondJsonObject.put("first_name", "Cloe");
        secondJsonObject.put("last_name", "Stuehmeyer");
        secondJsonObject.put("email", "cstuehmeyer1@yellowpages.com");
        secondJsonObject.put("gender", "female");

        List<Map<String, Object>> secondSkillSet = new ArrayList<Map<String, Object>>();

        Map<String, Object> skillSet1 = new LinkedHashMap<String, Object>();
        skillSet1.put("name","Testing");
        skillSet1.put("proficiency","Medium");

        secondSkillSet.add(skillSet1);

        Map<String, Object> skillSet2 = new LinkedHashMap<String, Object>();
        skillSet2.put("name","Java");
        skillSet2.put("proficiency","Begineer");
        List<String> certificate  = Arrays.asList("OCJP12","OCJP13");
        skillSet2.put("certifications",certificate);

        secondSkillSet.add(skillSet2);

        finalPayload.add(firstJsonObject);











        RestAssured
                .given()
                    .log()
                    .all()
                    .body(finalPayload)
                .when()
                    .get();

    }
}
