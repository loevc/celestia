package com.loevc.cloud.celestia.admin.service;

import com.loevc.cloud.celestia.common.constant.RabbitMqConstants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/29 16:29
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Provider {

    private final AmqpTemplate rabbitMqTemplate;

    public void send(){
        rabbitMqTemplate.convertAndSend("hello");
    }

    public void sendWithRt(){
        rabbitMqTemplate.convertAndSend(RabbitMqConstants.ROUTING_KEY_HELLO_V2,"hello  rt_v2");
    }

    public void sendWithExRt(){
        rabbitMqTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_HELLO_V1,RabbitMqConstants.ROUTING_KEY_HELLO_V2,"hello ex_v1 rt_v2");
    }

    @Value("${spring.rabbitmq.addresses}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;


    public void sendNormalMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);

        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()){
            channel.queueDeclare(RabbitMqConstants.QUEUE_NAME_HELLO_V1, false, false, false, null);
            String message =  "Hello World! ";
            channel.basicPublish("", RabbitMqConstants.QUEUE_NAME_HELLO_V1, null, message.getBytes());
            log.info(" [x] Sent '{}'", message);
        }
    }
}
