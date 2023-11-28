package com.loevc.cloud.celestia.admin.service.impl;

import com.loevc.cloud.celestia.admin.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/27 16:33
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public void d() {
        int a = 1;
        log.info("this a demo service");
    }
}
