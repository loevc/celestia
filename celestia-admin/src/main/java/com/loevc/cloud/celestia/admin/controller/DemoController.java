package com.loevc.cloud.celestia.admin.controller;

import com.loevc.cloud.celestia.admin.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/27 14:54
 * @Description TODO
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/demo")
@AllArgsConstructor
//@api
public class DemoController {

    private final DemoService demoService;



    @GetMapping("/d")
    public void d(){
        log.info("do nothing");
        log.info("todo ");
        demoService.d();
    }
}
