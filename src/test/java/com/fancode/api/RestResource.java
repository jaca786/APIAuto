package com.fancode.api;

import io.restassured.response.Response;

import static com.fancode.api.SpecBuilder.getRequestSpec;
import static com.fancode.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response get(String path) {
        return given(getRequestSpec()).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

}
