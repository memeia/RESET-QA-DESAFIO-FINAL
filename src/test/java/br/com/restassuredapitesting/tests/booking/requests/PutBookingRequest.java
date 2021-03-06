package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

    public Response updateBookingToken(int id, String token) {

        return given()
                .header("Content-Type", " application/json")
                .header("Accept", "application/json")
                .header("Cookie", token)
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/" + id);
    }

    public Response updateBookingAuth(int id, String auth) {

        return given()
                .header("Content-Type", " application/json")
                .header("Accept", "application/json")
                .header("Authorization", auth)
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/" + id);
    }

    
}
