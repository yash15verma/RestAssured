package apiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GET_Request {

    @Test
    public void getBooksDetails() {

        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Book";

        //Need to create a request object
        RequestSpecification httpRequest = RestAssured.given();

        //Need to create a response object
        Response response = httpRequest.request(Method.GET);
        httpRequest.pathParam("isbn", "9781449325862");

        //Print response in console window
        String responseBody = response.getBody().asPrettyString();
        System.out.println(responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status Code - " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //Status Line Validation
        String statusLine = response.getStatusLine();
        System.out.println("Status Line - " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
