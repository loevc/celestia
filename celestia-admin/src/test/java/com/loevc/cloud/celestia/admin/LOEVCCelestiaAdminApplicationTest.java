package com.loevc.cloud.celestia.admin;

import com.loevc.cloud.celestia.admin.service.Provider;
import com.loevc.cloud.celestia.common.constant.RabbitMqConstants;
import com.loevc.cloud.celestia.common.rabbitmq.RabbitMqConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/24 21:49
 * @Description TODO
 * @Version 1.0
 */

@Slf4j
@SpringBootTest
public class LOEVCCelestiaAdminApplicationTest {

    @Autowired
    private Provider provider;

    @Autowired
    private RabbitMqConnectionFactory rabbitMqConnectionFactory;

    @Autowired
    private ConnectionFactory rabbitMqFactory;

    @Test
    void testMq() throws IOException, TimeoutException {
        provider.sendNormalMessage();
        rabbitMqConnectionFactory.declareQueue(RabbitMqConstants.QUEUE_NAME_HELLO_V2);
        rabbitMqConnectionFactory.sendNormalMessage(RabbitMqConstants.QUEUE_NAME_HELLO_V3, "hello q_v3");
    }

    @Test
    void send10ThousandMsg() throws IOException, TimeoutException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Channel channel = rabbitMqFactory.newConnection().createChannel();
        for (int i = 0; i < 10000; i++) {
//            provider.sendNormalMessage();
//            rabbitMqConnectionFactory.sendNormalMessage(RabbitMqConstants.QUEUE_NAME_HELLO_V1, "Hello World ");
            rabbitMqConnectionFactory.sendNormalMessageWithChannel(RabbitMqConstants.QUEUE_NAME_HELLO_V1, "Hello World ", channel);
        }
        stopWatch.stop();
        log.info("total time: {}ms", stopWatch.getTotalTimeMillis());
    }
}
