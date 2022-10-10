package com.fancode.api;

import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.fancode.api.Endpoints.TODOS_ENDPOINT;


public class GetTodosApi {
    private static List status ;
    @Step
    public static Response getTodosApi() {
        return RestResource.get(TODOS_ENDPOINT);
    }

    @Step
    public static List statusCompleted(Response response, List fanCodeCity) {
        List<Map<String, Object>> responseBody = response.body().as(new TypeRef<List<Map<String, Object>>>() {
        });
        status = new ArrayList();
        for (int j = 0; j < responseBody.size(); j++) {
            for (int m = 0; m < fanCodeCity.size(); m++) {
                if (responseBody.get(j).get("id") == fanCodeCity.get(m)) {
                    status.add(responseBody.get(j).get("completed"));
                }
            }
        }
        return status;
    }

    @Step
    public static int completedCount() {
        int statusCount = 0;
        for (int a = 0; a < status.size(); a++) {
            if (status.get(a).equals(true)) {
                statusCount++;
            }
        }
        return statusCount;
    }

}
