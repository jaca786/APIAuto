package com.fancode.utils;

public enum StatusCode {
    CODE_200(200, "Success"),
    CODE_500(500, "Server Error"),
    CODE_400(400, "Missing required field: name"),
    CODE_401(401, "Invalid access token"),
    CODE_403(403, "Forbidden"),
    CODE_404(404, "resource not found");

    public final int code;
    public final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
