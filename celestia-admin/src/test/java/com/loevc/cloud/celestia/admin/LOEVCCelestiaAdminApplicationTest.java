package com.loevc.cloud.celestia.admin;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.loevc.cloud.celestia.admin.drools.entity.Order;
import com.loevc.cloud.celestia.admin.service.MongodbOperateService;
import com.loevc.cloud.celestia.admin.service.Provider;
import com.loevc.cloud.celestia.common.constant.RabbitMqConstants;
import com.loevc.cloud.celestia.common.entity.UserInfo;
import com.loevc.cloud.celestia.common.rabbitmq.RabbitMqConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
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
    void testOrder(){
        KieServices kieServices = KieServices.Factory.get();
        // 获取Kie容器对象 默认容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        // 从Kie容器对象中获取会话对象（默认session对象
        KieSession kieSession = kieContainer.newKieSession();

        Order order = new Order();
        order.setOriginalPrice(BigDecimal.valueOf(180));
        // 将order对象插入工作内存
        kieSession.insert(order);
        // 匹配对象
        // 激活规则，由drools框架自动进行规则匹配。若匹配成功，则执行
        kieSession.fireAllRules();
        log.info("优惠前价格：{} ,优惠后价格：{}" , order.getOriginalPrice(), order.getRealPrice());

        kieSession = kieContainer.newKieSession();
        order.setOriginalPrice(BigDecimal.valueOf(300));
        // 将order对象插入工作内存
        kieSession.insert(order);
        // 匹配对象
        // 激活规则，由drools框架自动进行规则匹配。若匹配成功，则执行
        kieSession.fireAllRules();
        log.info("优惠前价格：{} ,优惠后价格：{}" , order.getOriginalPrice(), order.getRealPrice());

        kieSession = kieContainer.newKieSession();
        order.setOriginalPrice(BigDecimal.valueOf(600));
        // 将order对象插入工作内存
        kieSession.insert(order);
        // 匹配对象
        // 激活规则，由drools框架自动进行规则匹配。若匹配成功，则执行
        kieSession.fireAllRules();
        log.info("优惠前价格：{} ,优惠后价格：{}" , order.getOriginalPrice(), order.getRealPrice());

        kieSession = kieContainer.newKieSession();
        order.setOriginalPrice(BigDecimal.valueOf(1200));
        // 将order对象插入工作内存
        kieSession.insert(order);
        // 匹配对象
        // 激活规则，由drools框架自动进行规则匹配。若匹配成功，则执行
        kieSession.fireAllRules();
        log.info("优惠前价格：{} ,优惠后价格：{}" , order.getOriginalPrice(), order.getRealPrice());

        kieSession = kieContainer.newKieSession();
        order.setOriginalPrice(BigDecimal.valueOf(3000));
        // 将order对象插入工作内存
        kieSession.insert(order);
        // 匹配对象
        // 激活规则，由drools框架自动进行规则匹配。若匹配成功，则执行
        kieSession.fireAllRules();
        log.info("优惠前价格：{} ,优惠后价格：{}" , order.getOriginalPrice(), order.getRealPrice());

        kieSession = kieContainer.newKieSession();
        order.setOriginalPrice(BigDecimal.valueOf(8000));
        // 将order对象插入工作内存
        kieSession.insert(order);
        // 匹配对象
        // 激活规则，由drools框架自动进行规则匹配。若匹配成功，则执行
        kieSession.fireAllRules();
        log.info("优惠前价格：{} ,优惠后价格：{}" , order.getOriginalPrice(), order.getRealPrice());

        kieSession = kieContainer.newKieSession();
        order.setOriginalPrice(BigDecimal.valueOf(12000));
        // 将order对象插入工作内存
        kieSession.insert(order);
        // 匹配对象
        // 激活规则，由drools框架自动进行规则匹配。若匹配成功，则执行
        kieSession.fireAllRules();
        log.info("优惠前价格：{} ,优惠后价格：{}" , order.getOriginalPrice(), order.getRealPrice());



        // 关闭会话
        kieSession.dispose();
    }


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
