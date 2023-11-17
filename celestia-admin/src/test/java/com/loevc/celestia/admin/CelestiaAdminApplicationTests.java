package com.loevc.celestia.admin;

import com.loevc.celestia.admin.factory.enums.FactoryEnum;
import com.loevc.celestia.admin.factory.logistics.Logistics;
import com.loevc.celestia.admin.factory.logistics.LogisticsFactory;
import com.loevc.celestia.admin.factory.logistics.RoadLogistics;
import com.loevc.celestia.admin.factory.strategy.LogisticsStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
class CelestiaAdminApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testFactory(){
        new RoadLogistics().createTransport().deliver();
    }

    @Test
    void testLogisticsFactory(){
        new LogisticsFactory().createTransport("ship").deliver();
    }

    @Test
    void testLogisticsStrategyFactory(){
        String str = null;
//        FactoryEnum factoryEnum = FactoryEnum.getFactoryEnumByName(str);
        Optional<FactoryEnum> enumOptional = Arrays.stream(FactoryEnum.class.getEnumConstants()).filter(anEnum -> anEnum.getName().equals(str)).findAny();
        if (enumOptional.isEmpty()) {
            log.error("this is not a strategy to choice");
            return;
        }
        Logistics logisticsInstance = new LogisticsStrategyFactory().getLogisticsInstance(enumOptional.get());
        logisticsInstance.createTransport().deliver();
    }

}
