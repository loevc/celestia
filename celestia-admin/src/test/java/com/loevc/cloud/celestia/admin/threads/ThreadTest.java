package com.loevc.cloud.celestia.admin.threads;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2024/1/3 13:48
 * @Description TODO
 * @Version 1.0
 */

@Slf4j
@SpringBootTest
public class ThreadTest {

    @Test
    void test1(){
        char a = 'a';
        log.info("{}", a + 1);
    }

}
