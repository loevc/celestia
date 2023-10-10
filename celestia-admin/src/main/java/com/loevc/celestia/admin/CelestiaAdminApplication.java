package com.loevc.celestia.admin;

import com.loevc.celestia.common.exception.GlobalExceptionHandler;
import com.loevc.celestia.common.util.GenerateVerificationCodeWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 协作探索项目，同时也是对知识的学习
 * 快速建立项目周期中，一些组件暂不提供
 */
@SpringBootApplication
@Import({GenerateVerificationCodeWeb.class, GlobalExceptionHandler.class})
public class CelestiaAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CelestiaAdminApplication.class, args);
    }

}
