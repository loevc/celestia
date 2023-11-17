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
public class LogisticsFactory {

    void playDelivery(){}

    public Transport createTransport(String name){
        log.warn("logistics super log , this line should be not appear");
        Transport transport;
        switch (name) {
            case "truck" -> transport = new RoadLogistics().createTransport();
            case "ship" -> transport = new SeaLogistics().createTransport();
            default -> {transport = new DefaultLogistics().createTransport();
                log.error("this is not having a factory to use ");}
        }
        log.info("factory create a object finished ");
        return transport;
    }
}



/*// java8
        switch (name){
                case "truck":
                transport = new RoadLogistics().createTransport();
                break;
                case "ship":
                transport = new SeaLogistics().createTransport();
                break;
default:
        log.error("this is not having a factory to use ");
        }*/
