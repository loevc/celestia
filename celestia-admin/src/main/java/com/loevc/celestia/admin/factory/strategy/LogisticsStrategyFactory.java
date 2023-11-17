package com.loevc.celestia.admin.factory.strategy;

import com.loevc.celestia.admin.factory.enums.FactoryEnum;
import com.loevc.celestia.admin.factory.logistics.DefaultLogistics;
import com.loevc.celestia.admin.factory.logistics.Logistics;
import com.loevc.celestia.admin.factory.logistics.RoadLogistics;
import com.loevc.celestia.admin.factory.logistics.SeaLogistics;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/17 14:21
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class LogisticsStrategyFactory {

    private static final Map<FactoryEnum, Logistics> logisticsMap = new HashMap<>(8);

    private static final DefaultLogistics defaultLogistics = new DefaultLogistics();

    static {
        logisticsMap.put(FactoryEnum.ROAD, new RoadLogistics());
        logisticsMap.put(FactoryEnum.SEA, new SeaLogistics());
    }

    public Logistics getLogisticsInstance(FactoryEnum factoryEnum){
        if (!logisticsMap.containsKey(factoryEnum)){
            log.warn("this is not a can usable strategy ");
            return defaultLogistics;
        }
        return logisticsMap.get(factoryEnum);
    }
}
