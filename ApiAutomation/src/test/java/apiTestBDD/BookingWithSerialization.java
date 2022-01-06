package apiTestBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BookingWithSerialization {

    @Test
    public void createBookingSerialization(){

        ArrayList<Object> bookingDateList = new ArrayList<Object>();
        bookingDateList.add()

        Booking book = new Booking();
        book.setFirstName("John");
        book.setLastName("Bran");
        book.setTotalPrice(200);
        book.setDepositPaid(true);
        book.setCheckInDate("2019-01-09");
        book.setCheckOutDate("2019-08-23");
        book.setAdditionalNeeds("Lunch");

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    .contentType(ContentType.JSON)
                    .body(book)
                .when()
                    .post()
                .then()
                    .log().all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath())


    }
}
