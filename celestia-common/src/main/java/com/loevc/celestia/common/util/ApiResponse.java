package com.loevc.celestia.common.util;
import lombok.Data;

@Data
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
}
