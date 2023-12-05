package com.loevc.cloud.celestia.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/25 0:44
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.loevc.cloud")
public class LOEVCCelestiaListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LOEVCCelestiaListenerApplication.class, args);
        log.info("\n<celestia listener>   \nservice \nis  \nrunning \n\n\n");
    }
}
