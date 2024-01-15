package com.loevc.cloud.celestia.common;


import com.loevc.cloud.celestia.common.util.algorithm.sort.InsertionSort;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/21 9:34
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class LOEVCCelestiaCommonTest {

    static class Stu{
        String id;
        Integer no;
    }


    @Test
    void testNum(){
        Integer a = new Integer(2333);
//        log.info("{}", a.hashCode()); // 调用hashcode会导致什么问题
        sub(a);
        System.out.println(a);

        Stu stu = new Stu();
        stu.id = "1";
        stu.no = 1;
        modify(stu);
        log.info("{}",stu.no);
    }

    private static void modify(Stu stu){
        stu.id = "2";
        stu.no = 2;
    }

    private static void sub(Integer a){
        a = a - 20;
        log.info("{}", a);
    }


    @Test
    void testInsertSort(){
        int[] aInt = new int[]{5, 2, 6, 4, 7, 3};
        InsertionSort.insertSortByInt(aInt);
        log.info("{}", IntStream.range(5, 50).toArray());
//        log.info("{}", new Random().ints(5, 50).toArray());
        log.info("{}", new Random().ints(5, 50).limit(20).toArray());
    }

    @Test
    void testInsertSort2(){
        InsertionSort.insertSortByInt(new Random().ints(5, 50).limit(20).toArray());
    }



}
