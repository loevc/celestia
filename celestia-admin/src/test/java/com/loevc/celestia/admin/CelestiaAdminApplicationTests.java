package com.loevc.celestia.admin;

import com.loevc.celestia.admin.bridge.action.Black;
import com.loevc.celestia.admin.bridge.action.Color;
import com.loevc.celestia.admin.bridge.action.White;
import com.loevc.celestia.admin.bridge.substance.Circle;
import com.loevc.celestia.admin.bridge.substance.Rectangle;
import com.loevc.celestia.admin.bridge.substance.Shape;
import com.loevc.celestia.admin.bridge.substance.Square;
import com.loevc.celestia.admin.factory.enums.FactoryEnum;
import com.loevc.celestia.admin.factory.logistics.Logistics;
import com.loevc.celestia.admin.factory.logistics.LogisticsFactory;
import com.loevc.celestia.admin.factory.logistics.RoadLogistics;
import com.loevc.celestia.admin.factory.strategy.LogisticsStrategyFactory;
import com.loevc.celestia.admin.pipeline.context.goodsinfo.GoodsInfoContext;
import com.loevc.celestia.admin.pipeline.context.orderinfo.OrderInfoContext;
import com.loevc.celestia.admin.pipeline.PipelineExecutor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@Slf4j
@SpringBootTest
class CelestiaAdminApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testBridge(){
        Color color = new Black();
        Shape shape = new Square();

        shape.setColor(color);
        shape.draw();
    }


    @Autowired // 不能使用 private final 的全参构造， 在测试启动类中无法启动
    private PipelineExecutor pipelineExecutor;

    @Test
    void testPipeline(){
        pipelineExecutor.acceptSync(new GoodsInfoContext());
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
