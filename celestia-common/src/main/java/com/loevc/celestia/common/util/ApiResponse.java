package com.loevc.celestia.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse<T> {

    private int code; // 响应状态码
    private String msg; // 响应消息
    private T data; // 响应数据

    public ApiResponse() {

    }

    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResponse restResult(int code, String msg, T data) {
        ApiResponse<T> apiResult = new ApiResponse();
        apiResult.setCode(code);
        apiResult.setData(data);
        return apiResult;
    }
}

