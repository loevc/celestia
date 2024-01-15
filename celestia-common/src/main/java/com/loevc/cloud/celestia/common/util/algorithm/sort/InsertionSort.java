package com.loevc.cloud.celestia.common.util.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/21 9:21
 * @Description TODO
 * @Version 1.0
 */

@Slf4j
public class InsertionSort {

    /**
     * non-descending order
     * @param aInt
     * @return
     */
    public static int[] insertSortByInt(int[] aInt){
        log.info("int[] init status: {}", aInt);
        if (aInt == null || aInt.length <= 1)
            return aInt;
        for (int j = 1; j < aInt.length; ++j){
            int key = aInt[j];
//            log.info("card will come: {}", key);
            int i = j - 1;
            while (i > -1 && aInt[i] > key){
                aInt[i + 1] = aInt[i];
                --i;
            }
            aInt[i + 1] = key;
            log.info("cards in my hand: {}", Arrays.stream(aInt).limit(j+1).toArray());
//            log.info("int temp result({}): {}, move cnt: {}", j, aInt, j - 1 - i);
        }
        log.info("int[] final status: {}", aInt);
        return aInt;
    }


}
