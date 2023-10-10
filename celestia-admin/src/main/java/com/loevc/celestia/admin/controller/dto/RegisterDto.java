package com.loevc.celestia.admin.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author caijiliu
 * @Email L13831467435@163.com
 * @Date 2023/10/10 18:10
 * @Description
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class RegisterDto {
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String code;
}
