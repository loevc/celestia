package com.loevc.celestia.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @Author caijiliu
 * @Email L13831467435@163.com
 * @Date 2023/10/10 17:44
 * @Description 生成验证码网页
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class GenerateVerificationCodeWeb {
    public static String createVerificationCodeEmailContent(String verificationCode) {
        Context context = new Context();
        context.setVariable("verificationCode", verificationCode);
        TemplateEngine templateEngine = new TemplateEngine();
        return templateEngine.process("email-template", context);
    }
}
