package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

    public Response createBooking(){

        return given()
                .header("Content-Type", " application/json")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }
}
