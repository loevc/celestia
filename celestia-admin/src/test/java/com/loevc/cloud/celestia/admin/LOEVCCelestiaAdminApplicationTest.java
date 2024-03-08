package com.loevc.cloud.celestia.admin;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    @Autowired
    private MongodbOperateService mongodbOperateService;


    @Test
    void testMongo(){
        Object obj = mongodbOperateService.saveObj(new UserInfo() {{
            setId("133");
            setFirstName("bbbbb");
            setEmail("333");
        }}, "celestia");
        log.info("{}", obj);
    }

    @Value("${boolean:true}")
    private Boolean aBoolean;

    @Value("${boolean2:true}")
    private boolean aBoolean2;

    @Test
    void testValue(){
        log.info("{}", aBoolean);
        log.info("{}", aBoolean2);
    }


    @Test
    void testGenerate(){
        System.err.println(generateExpr());
    }

    private String generateExpr() {
        return JSONUtil.toJsonStr(new HashMap<String, String>() {{
            put("x<360", "0");
            put("x>=360&&x<393", "5");
            put("x>=393&&x<423", "10");
            put("x>=423&&x<453", "15");
            put("x>=453&&x<480", "20");
            put("x>=480", "20");
        }});
    }

    @Test
    void testString(){
        String a = "Ireland";
        String b = new String("IreIand");
        String c = new String("lreland").intern();
        String d = new String("lreIand").intern();
        System.out.println("a == b: " + (a == b) + ", c == d: " + (c == d));
    }


    static class A{}
    static class B extends A{}
    static class C extends B{}
    static class D extends C{}
    static class E extends D{}
    static class F extends E{}
    static class G extends F{}

    static class Example<T>{}
    @Test
    void testGenerateType(){
        {
            Example<? extends A> testAA = new Example<A>();
            Example<? extends A> testAB = new Example<B>();
            Example<? extends A> testAC = new Example<C>();
//            Example<? extends B> testBA = new Example<A>();
            Example<? extends B> testBB = new Example<B>();
            Example<? extends B> testBC = new Example<C>();
//            Example<? extends C> testCA = new Example<A>();
//            Example<? extends C> testCB = new Example<B>();
            Example<? extends C> testCC = new Example<C>();
        }
        {
            Example<? super A> testAA = new Example<A>();
//            Example<? super A> testAB = new Example<B>();
//            Example<? super A> testAC = new Example<C>();
            Example<? super B> testBA = new Example<A>();
            Example<? super B> testBB = new Example<B>();
//            Example<? super B> testBC = new Example<C>();
            Example<? super C> testCA = new Example<A>();
            Example<? super C> testCB = new Example<B>();
            Example<? super C> testCC = new Example<C>();
        }

        List<? extends D> extendsD = new ArrayList<>();
        List<? super D> superD = new ArrayList<>();

//        superD.add(new A());
//        superD.add(new B());
//        superD.add(new C());
        superD.add(new D());
        superD.add(new E());
        superD.add(new F());
        superD.add(new G());

//        extendsD.add(new G());
//        extendsD.add(new F());
//        extendsD.add(new E());
//        extendsD.add(new D());
//        extendsD.add(new C());
//        extendsD.add(new B());
//        extendsD.add(new A());

//        A superDA = superD.get(0);
//        B superDB = superD.get(0);
//        C superDC = superD.get(0);
//        D superDD = superD.get(0);
//        E superDE = superD.get(0);
//        F superDF = superD.get(0);
//        G superDG = superD.get(0);

//        G extendsDG = extendsD.get(0);
//        F extendsDF = extendsD.get(0);
//        E extendsDE = extendsD.get(0);
        D extendsDD = extendsD.get(0);
        C extendsDC = extendsD.get(0);
        B extendsDB = extendsD.get(0);
        A extendsDA = extendsD.get(0);
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
