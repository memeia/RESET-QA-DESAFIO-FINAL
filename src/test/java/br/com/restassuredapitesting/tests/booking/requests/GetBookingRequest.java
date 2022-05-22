package br.com.restassuredapitesting.tests.booking.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {
    public Response bookingReturnIds() {
        return given()
                .when()
                .get("booking");
    }

    public Response bookingReturnId(int id) {
        return given()
                .when()
                .get("booking/" + id);
    }

    public Response filterByFirstName(String firstname) {
        return given()
                .when()
                .get("booking?firstname=" + firstname);
    }


    public Response filterByLastName(String lastname) {
        return given()
                .when()
                .get("booking?lastname=" + lastname);
    }


    public Response filterByDateCheckin(String datein) {
        return given()
                .when()
                .get("booking?checkin=" + datein);
    }


    public Response filterByDateCheckout(String dateout) {
        return given()
                .when()
                .get("booking?checkout=" + dateout);
    }


    public Response filterByDateCheckinAndCheckout(String datein, String dateout) {
        return given()
                .when()
                .get("booking?checkin=" + datein + "&checkout=" + dateout);
    }

    public Response filterByFullNameDateCheckinAndCheckout(String firstname, String lastname, String datein, String dateout) {
        return given()
                .when()
                .get("booking?firstname=" + firstname + "booking?lastname=" + lastname + "booking?checkin=" + datein + "&checkout=" + dateout);
    }
}
