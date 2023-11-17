package com.loevc.celestia.admin.factory.logistics;

import com.loevc.celestia.admin.factory.transport.Ship;
import com.loevc.celestia.admin.factory.transport.Transport;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/17 13:28
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class SeaLogistics extends Logistics{

    @Override
    public Ship createTransport() {
        log.info("create a ship object");
        return new Ship();
    }
}
