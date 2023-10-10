package com.loevc.celestia.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class CelestiaAdminApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 使用jdk8 和  jdk17 展示完全不同的效果
     */
    @Test
    void testMapMerge(){
        List<Stu> list = Arrays.asList(
                new Stu("1","liu"),
                new Stu("2","dong"),
                new Stu("1","yang")
        );

        Map<String, String> collect = list.stream().collect(Collectors.toMap(obj -> obj.id, obj -> obj.name));
        System.out.println(collect);
    }


    private class Stu{
        String id, name;

        Stu(String id, String name){
            this.id = id;
            this.name = name;
        }
    }

    @Test
    void testMerge2(){
        List<Something> list = Arrays.asList(
                new Something("key1", "value1"),
                new Something("key2", "value2"),
                new Something("key3", "value3a"),
                new Something("key3", "value3b"));

        Map<String, String> map = list.stream().collect(Collectors.toMap(o -> o.key, o -> o.value));
        System.out.println(map);
    }

    private static class Something {
        final String key, value;

        Something(final String key, final String value){
            this.key = key;
            this.value = value;
        }
    }

}
