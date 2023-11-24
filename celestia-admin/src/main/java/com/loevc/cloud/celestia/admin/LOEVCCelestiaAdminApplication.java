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
        SpringApplication.run(LOEVCCelestiaAdminApplication.class, args);
        log.info("service is running ");
    }
}
