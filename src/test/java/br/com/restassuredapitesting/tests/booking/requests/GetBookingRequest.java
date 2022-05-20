package br.com.restassuredapitesting.tests.booking.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {
    public Response bookingReturnIds(){
        return given()
                .when()
                .get("booking");

    }

    public Response bookingReturnId(int id){
        return given()
                .when()
                .get("booking/"+id);

    }
}
