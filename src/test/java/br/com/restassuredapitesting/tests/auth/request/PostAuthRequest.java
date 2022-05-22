package br.com.restassuredapitesting.tests.auth.request;

import br.com.restassuredapitesting.tests.auth.request.payload.AuthPayloads;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {
    AuthPayloads authPayloads = new AuthPayloads();

    public Response tokenReturn() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(authPayloads.jsonAuthLogin().toString())
                .post("auth");
    }

    public String getToken() {
        return "token=" + this.tokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }

    public String getAuth() {

        String name = "admin";
        String password = "password123";

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());

        String auth = new String(authEncBytes);

        return "Basic " + auth;
    }
}
