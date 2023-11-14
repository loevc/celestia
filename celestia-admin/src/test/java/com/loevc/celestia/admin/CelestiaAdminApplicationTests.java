package com.loevc.celestia.admin;

import cn.hutool.json.JSONObject;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.loevc.celestia.common.util.ExcelUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.stream.Collectors;

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

        new Thread(()->
            System.out.println("aaaa")
        ).start();

        List<Integer> res = new ArrayList<>();
        Strings.parallelStream().forEach(res::add);

        System.out.println(res.indexOf(null));

        System.out.println("size: " + res.size());

//        res.forEach(System.out::println);
    }

    @Test
    void testC(){
        Stack<Object> stack = new Stack<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> b-a);
        queue.offer(4);
        queue.offer(1);
        queue.offer(7);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue.poll());
        }
    }

    @Test
    void compactTwoNumber(){
        int a = 3;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a " +  a  + "    b" + b);

    }

    @Test
    void testBreak(){
        for (int i = 0; i < 10; i++) {
            System.out.println("aaaa");
            for (int j = 0; j < 10; j++) {
                if (j < 100) break;
                System.out.println("bbbbb");
            }
        }
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


    /**
     * need to add jvm parameters :
     */
    @Deprecated
    @Test
    public void personTotal(){
//        List<WriteVO> list = new ArrayList<>();
        File file = new File("sourceDir");
        String path = "destDir";
        if (file.isDirectory()){
            Arrays.stream(file.listFiles()).forEach(item -> {
                String name = item.getName();
                if (item.isDirectory()){
                    long count = Arrays.stream(item.listFiles()).count();
                    Arrays.stream(item.listFiles()).forEach(sub -> {
                        try {
                            copyFileUsingFileChannels(sub, new File(path + sub.getName()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
//                    list.add(new WriteVO(name, count));
                }
            });
        }
//        ExcelUtil.writeExcel2File(list, "tongji.xlsx", WriteVO.class);
    }

    @Data
    @ExcelIgnoreUnannotated
    @AllArgsConstructor
    class WriteVO{

        @ExcelProperty(value = "名字",index = 0)
        private String name;

        @ExcelProperty(value = "数量",index = 1)
        private long cnt;
    }

    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }
}
