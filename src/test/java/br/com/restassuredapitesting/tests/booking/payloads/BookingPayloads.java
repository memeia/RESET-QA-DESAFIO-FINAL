package br.com.restassuredapitesting.tests.booking.payloads;

import org.json.JSONObject;

public class BookingPayloads {
    public static JSONObject payloadValidBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2018-01-02");

        payload.put("firstname", "Cristiano");
        payload.put("lastname", "Ronaldo");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingdates);
        payload.put("addiotnalneeds", "breakfast");

        return payload;

    }
}
