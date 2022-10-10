package com.fancode.tests;

import com.fancode.api.GetTodosApi;
import com.fancode.api.GetUsersApi;
import com.fancode.tests.base.BaseTest;
import com.fancode.utils.ApiUtils;
import com.fancode.utils.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class TodosTaskTest extends BaseTest {

    @Test
    public void todosTaskCompletedScenario() {
        //Users API
        Response response = GetUsersApi.getUsersApi();
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        List fanCodeCity = GetUsersApi.fancodeCity(response);


        //todos API
        Response responseTodos = GetTodosApi.getTodosApi();
        assertStatusCode(responseTodos.statusCode(), StatusCode.CODE_200);
        List status = GetTodosApi.statusCompleted(responseTodos, fanCodeCity);

        int statusCompletedCount = GetTodosApi.completedCount();
        float percentage = ApiUtils.calculatePercentage(statusCompletedCount, status.size());

        assertTrue(percentage > 50, "User completed task percentage should be greater than 50 % for " +
                "Fancode City and percentage found is:-> " + percentage);
    }

}
