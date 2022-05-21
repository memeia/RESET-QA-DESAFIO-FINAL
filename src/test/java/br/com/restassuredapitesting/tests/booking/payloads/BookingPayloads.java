package br.com.restassuredapitesting.tests.booking.payloads;

import org.json.JSONObject;

public class BookingPayloads {
    public static JSONObject payloadValidBooking() {
        JSONObject payload = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2018-01-02");

        payload.put("firstname", "Cristiano");
        payload.put("lastname", "Ronaldo");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingdates);
        payload.put("additionalneeds", "breakfast");

        return payload;

    }


    public static JSONObject payloadInvalidBooking() {
        JSONObject payload = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "data1");
        bookingdates.put("checkout", "data2");

        payload.put("firstname", 111);
        payload.put("lastname", 222);
        payload.put("totalprice", "preco");
        payload.put("depositpaid", "oi");
        payload.put("bookingdates", bookingdates);
        payload.put("additionalneeds", "breakfast");

        return payload;

    }


    public static JSONObject payloadMaisParametros() {
        JSONObject payload = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2018-01-02");

        payload.put("firstname", "Cristiano");
        payload.put("lastname", "Ronaldo");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingdates);
        payload.put("additionalneeds", "breakfast");
        payload.put("numberHosts", 3);

        return payload;

    }


}
