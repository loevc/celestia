package com.loevc.cloud.celestia.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/30 11:09
 * @Description TODO
 * @Version 1.0
 */
@Data
//@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitmqProperty {

    private String addresses;

    private Integer port;

    private String username;

    private String password;

    private String virtualHost;
}
