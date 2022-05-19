package br.com.restassuredapitesting.tests.auth.request;

import br.com.restassuredapitesting.tests.auth.request.payload.AuthPayloads;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {
    AuthPayloads authPayloads = new AuthPayloads();

    public Response tokenReturn(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(authPayloads.jsonAuthLogin().toString())
                .post("auth");
    }

    public String getToken(){
        return  "token="+this.tokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
