package com.loevc.cloud.celestia.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/24 15:21
 * @Description TODO
 * @Version 1.0
 */

@Slf4j
@SpringBootApplication
public class LOEVCCelestiaAdminApplication {

    public static void main(String[] args) {
//        System.setProperty("nacos.logging.default.config.enabled", "false");
        SpringApplication.run(LOEVCCelestiaAdminApplication.class, args);
        log.info("\n<celestia admin>   \nservice \nis  \nrunning ");
    }
}
