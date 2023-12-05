package com.loevc.cloud.celestia.listener.cunsumers;

import com.loevc.cloud.celestia.common.constant.RabbitMqConstants;
import com.loevc.cloud.celestia.common.rabbitmq.RabbitMqConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/29 21:29
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Component
public class HelloConsumer {


    @Autowired
    private RabbitMqConnectionFactory rabbitMqConnectionFactory;

    @Autowired
    private Channel rabbitMqChannel;

    @Bean // 如果需要监听mq消息，那就需要把消费者注册一下才可以呀
    public void solveMessage() throws IOException, TimeoutException {
        String queueNameHelloV2 = RabbitMqConstants.QUEUE_NAME_HELLO_V2;

        rabbitMqConnectionFactory.declareQueueByConsume(queueNameHelloV2);
        log.info(" [*] Waiting for messages. ");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            log.info(" [*] received {}", message);
        };

        rabbitMqChannel.basicConsume(queueNameHelloV2, true, deliverCallback, consumerTag -> {});
    }
}
