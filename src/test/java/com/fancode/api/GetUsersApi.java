package com.fancode.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.fancode.api.Endpoints.USERS_ENDPOINT;

public class GetUsersApi {

    @Step
    public static Response getUsersApi() {
        return RestResource.get(USERS_ENDPOINT);
    }

    @Step
    public static List fancodeCity(Response response) {
        List<Map<String, String>> res = response.jsonPath().getList("address.geo");

        List city = new ArrayList();
        for (int i = 0; i < res.size(); i++) {
            if (Double.parseDouble(res.get(i).get("lat")) > -40 && Double.parseDouble(res.get(i).get("lat")) < 5 && Double.parseDouble(res.get(i).get("lng")) > 5 && Double.parseDouble(res.get(i).get("lng")) < 100) {
                city.add(response.jsonPath().getList("id").get(i));
            }
        }
        return city;
    }

}
