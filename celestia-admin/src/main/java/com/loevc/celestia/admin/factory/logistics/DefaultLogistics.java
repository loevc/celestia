package com.loevc.celestia.admin.factory.logistics;

import com.loevc.celestia.admin.factory.transport.DefaultTransport;
import com.loevc.celestia.admin.factory.transport.Truck;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/17 13:28
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class DefaultLogistics extends Logistics{

    @Override
    public DefaultTransport createTransport() {
        log.info("create a default object");
        return new DefaultTransport();
    }

}
