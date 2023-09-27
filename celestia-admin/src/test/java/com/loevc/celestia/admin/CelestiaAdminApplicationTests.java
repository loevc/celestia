package com.loevc.celestia.admin;

import cn.hutool.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@SpringBootTest
class CelestiaAdminApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    void testLongCompare(){
        Long num = 1L;
        long num2 = 1L;
        System.out.println(num == num2);
    }

    @Test
    void testJsonObject(){
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject);
        jsonObject.putOpt("deepPageId","11");
        System.out.println(jsonObject);
    }

    @Test
    void parallelStream(){
        List<Integer> Strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Strings.add(i);
        }

        List<Integer> res = new ArrayList<>();
        Strings.parallelStream().forEach(res::add);

        System.out.println(res.indexOf(null));

        System.out.println("size: " + res.size());

//        res.forEach(System.out::println);
    }

}
