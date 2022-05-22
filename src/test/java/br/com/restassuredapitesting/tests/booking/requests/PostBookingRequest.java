package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class PostBookingRequest {
    public BookingPayloads bookingPayloads = new BookingPayloads();


    public Response createBooking() {

        return given()
                .header("Content-Type", " application/json")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }

    public Response createInvalidBooking() {

        return given()
                .header("Content-Type", " application/json")
                .when()
                .body(bookingPayloads.payloadInvalidBooking().toString())
                .post("booking");
    }

    public Response createBookingMaisParametros() {

        return given()
                .header("Content-Type", " application/json")
                .when()
                .body(bookingPayloads.payloadMaisParametros().toString())
                .post("booking");
    }

    public Response createBookingByPayload(String payload) {

        return given()
                .header("Content-Type", " application/json")
                .when()
                .body(payload)
                .post("booking");
    }
}
