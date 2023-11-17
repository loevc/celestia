package com.loevc.celestia.admin.factory.transport;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/17 13:26
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class DefaultTransport implements Transport{


    @Override
    public void deliver() {
        log.info("now <default> is transport, so do nothing ");
    }
}
