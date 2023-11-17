package com.loevc.celestia.admin.factory.logistics;

import com.loevc.celestia.admin.factory.transport.Transport;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/17 13:27
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public abstract class Logistics {

    void playDelivery(){}

    public Transport createTransport(){
        log.warn("logistics super log , this line should be not appear");
        return null;
    }
}
