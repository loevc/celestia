package com.loevc.cloud.celestia.common.rabbitmq;

import com.loevc.cloud.celestia.common.properties.RabbitmqProperty;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/29 21:34
 * @Description TODO
 *  * (AMQP default) (direct) D
 *  * amq.direct (direct) D
 *  * amq.fanout (fanout) D
 *  * amq.headers (headers) D
 *  * amq.match (headers) D
 *  * amq.rabbitmq.trace (topic) D I
 *  * amq.topic (topic) D
 * @Version 1.0
 */
@Slf4j
@Component
@AllArgsConstructor
public class RabbitMqConnectionFactory {

    private final ConnectionFactory rabbitMqFactory;

    public void sendNormalMessage(String queueName, String message) throws IOException, TimeoutException {
        try(Connection connection = rabbitMqFactory.newConnection();
            Channel channel = connection.createChannel()){
            channel.basicPublish("", queueName, null, message.getBytes());
            log.info(" [x] Sent '{}'", message);
        }
    }

    /**
     * 写这个方法，起因： 想向队列中发送1万条消息，但是很慢，平均每秒只有7条的速率或者更低
     * 观察上一个方法，发现代码中为每条消息创建了一个通道，该方法取消了通道的重复创建。
     * 效果： 1万条消息，瞬时发送成功
     * 10万条消息: 10938ms  8C32G服务器，rabbitmqServer端最高cpu 70% 中值46%  最低15%  mem 2%~3.5%
     * 10万条消息: 大概占用rabbitmqServer中， 20MB内存空间，稳定后占用64M空间 最终稳定后占用 135M (该段记录不准确，影响因素多)
     * 大量的消息占用，似乎会让该交换机和队列保持某种活跃状态
     *
     * 百万级消息注意： connections会不会自动增加，为什么初始1个，中途会变成2个，是维持还是其他
     * 百万级消息注意： channels会不会自动增加，初始1个，中途变成2个，
     * 百万级消息注意： channel峰值速度 14000/s  queue峰值速度 10000/s
     * 百万级消息注意： connections channels exchanges 等state 字段值   flow  running idle 等
     * @param queueName
     * @param message
     * @param channel
     * @throws IOException
     */
    public void sendNormalMessageWithChannel(String queueName, String message, Channel channel) throws IOException {
        channel.basicPublish("", queueName, null, message.getBytes());
        log.info(" [x] Sent '{}'", message);
    }


/*    private void createChannel() throws IOException, TimeoutException{
        try(Connection connection = rabbitMqFactory.newConnection();
            Channel channel = connection.createChannel()){
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message =  "Hello World! ";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            log.info(" [x] Sent '{}'", message);
        }
    }*/




    public void declareQueue(String queueName) throws IOException, TimeoutException{
        try (Connection connection = rabbitMqFactory.newConnection();
             Channel channel = connection.createChannel()){
            channel.queueDeclare(queueName, false, false, false, null);
            log.info("queue {} declare success ", queueName);
        }
    }

    public void declareQueueByConsume(String queueName) throws IOException, TimeoutException {
        Connection connection = rabbitMqFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
        log.info("queue {} declare success ", queueName);
    }





}
