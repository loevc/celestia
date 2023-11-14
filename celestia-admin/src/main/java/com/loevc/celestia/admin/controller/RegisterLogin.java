package com.loevc.celestia.admin.controller;

import com.loevc.celestia.admin.controller.dto.RegisterDto;
import com.loevc.celestia.admin.service.EmailService;
import com.loevc.celestia.admin.service.RedisService;
import com.loevc.celestia.admin.service.impl.EmailServiceImpl;
import com.loevc.celestia.admin.service.impl.RedisServiceImpl;
import com.loevc.celestia.common.util.ApiResponse;
import com.loevc.celestia.common.util.GenerateRandomDigitUtil;
import com.loevc.celestia.common.util.GenerateVerificationCodeWeb;
import com.loevc.celestia.common.util.ResponseCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @Author caijiliu
 * @Email L13831467435@163.com
 * @Date 2023/10/10 17:30
 * @Description 注册登录控制器
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/registerLogin")
@RequiredArgsConstructor
public class RegisterLogin {
    private final RedisService RedisService;
    private final EmailService EmailService;

    @GetMapping("/sendCode")
    public ApiResponse sendCode(@RequestParam(value = "email", required = false) String email) {
        if (email == null) {
            return ApiResponse.restResult(ResponseCode.Fail.getCode(), "请传Email", null);
        } else {
            String s = GenerateRandomDigitUtil.getSixDigitVerifyCode();
            String htmlContent = GenerateVerificationCodeWeb.createVerificationCodeEmailContent(s);
            EmailService.sendEmail(email, "邮箱验证码", htmlContent);
            RedisService.setValueWithTTL(email, s, 60 * 5, TimeUnit.SECONDS);
            return ApiResponse.restResult(ResponseCode.SUCCESS.getCode(), "发送成功,有效期5分钟！", null);
        }
    }

    @PostMapping("/register")
    public ApiResponse register(@RequestBody @Valid RegisterDto registerDto) {
        log.info(registerDto.toString());

        return ApiResponse.restResult(ResponseCode.SUCCESS.getCode(), "注册成功", null);
    }

}
