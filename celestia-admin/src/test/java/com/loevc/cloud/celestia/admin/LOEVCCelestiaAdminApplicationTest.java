package com.loevc.cloud.celestia.admin;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.loevc.cloud.celestia.admin.service.MongodbOperateService;
import com.loevc.cloud.celestia.admin.service.Provider;
import com.loevc.cloud.celestia.common.constant.RabbitMqConstants;
import com.loevc.cloud.celestia.common.entity.UserInfo;
import com.loevc.cloud.celestia.common.rabbitmq.RabbitMqConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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


    @Autowired
    private MongodbOperateService mongodbOperateService;

    private static final int SCALE = 63;


    @Test
    void testBitGroup() {
        List<Integer> locs = Arrays.asList(1, 62, 63, 64, 65, 126, 127, 128);
        Map<Integer, List<Integer>> resMap = locs.stream()
                .collect(Collectors.groupingBy(loc -> (loc-1) / SCALE));
        log.info("{}", resMap);
        log.info("{}", JSONUtil.toJsonStr(resMap.keySet().stream().map(k -> k + 1).sorted().collect(Collectors.toList())));
        resMap.keySet().forEach(key -> {
            List<Integer> locations = resMap.get(key);
            if (CollUtil.isNotEmpty(locations)) {
                String fieldName = "applySceneV" + (key + 1);
                log.info("{}", fieldName);
                AtomicReference<Long> longVal = new AtomicReference<>(0L);
                log.info("locations ?   {}", locations);
                BigDecimal bigDecimal = new BigDecimal(0);
                for (Integer location : locations) {
                    log.info("location :  {}", location);
                    BigDecimal augend = new BigDecimal(1L << (location - 1) % SCALE);
                    log.info("augend : {}", augend);
                    bigDecimal.add(augend);
                }
                log.info("{}", bigDecimal);
                locations.forEach(location -> longVal.updateAndGet(v -> v | 1L << (location - 1) % SCALE));
                log.info("lonVal : {}", longVal.get());
            }
        });
    }

    @Test
    void testLongBit(){
        long l = 0L;
        for (int i = 0; i < 65 ; ++i){
            if (i < 63){
                l += 1L << i;
            }
            log.info("left move : {}  res:  {}", i,  1L << i);
        }
            log.info(" {}", l);
            log.info(" {}", l + 1);
            log.info(" {}", SCALE | 1);
    }


    @Test
    void testMongo(){
        Object obj = mongodbOperateService.saveObj(new UserInfo() {{
            setId("133");
            setFirstName("bbbbb");
            setEmail("333");
        }}, "celestia");
        log.info("{}", obj);
    }


    @Test
    void testMapNull(){
        Map<String, String> map = new HashMap<>();
        map.put(null, "null");
        System.out.println(map.containsKey(null));
        System.out.println("aaaaa");
    }

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
