package com.loevc.cloud.celestia.common.config;

import com.loevc.cloud.celestia.common.properties.RabbitmqProperty;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/4 10:17
 * @Description TODO
 * @Version 1.0
 */
@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

    private final RabbitmqProperty rabbitmqProperty;

    private ConnectionFactory factory;

    @Bean("rabbitMqFactory")
    public ConnectionFactory initialFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        this.factory = factory;
        factory.setHost(rabbitmqProperty.getAddresses());
        factory.setPort(rabbitmqProperty.getPort());
        factory.setUsername(rabbitmqProperty.getUsername());
        factory.setPassword(rabbitmqProperty.getPassword());
        factory.setVirtualHost(rabbitmqProperty.getVirtualHost());
        return factory;
    }

    @Bean("rabbitMqChannel")
    public Channel getChannel() throws IOException, TimeoutException {
        return factory.newConnection().createChannel();
    }
}
