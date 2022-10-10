package com.fancode.tests.base;

import com.fancode.utils.StatusCode;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("STARTING TEST: " + m.getName());
    }

    @Step("Status code should be as expected")
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    @Step("Assert DataField")
    public void assertTrue(Boolean value, String message) {
        Assert.assertTrue(value, message);
    }

}
