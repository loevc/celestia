package com.loevc.celestia.admin.pipeline.config;

import com.loevc.celestia.admin.pipeline.context.goodsinfo.GoodsInfoContext;
import com.loevc.celestia.admin.pipeline.handlers.ContextHandler;
import com.loevc.celestia.admin.pipeline.context.orderinfo.OrderInfoContext;
import com.loevc.celestia.admin.pipeline.context.PipelineContext;
import com.loevc.celestia.admin.pipeline.handlers.goodsinfo.DeleteGoodsInfoHandler;
import com.loevc.celestia.admin.pipeline.handlers.goodsinfo.InitialGoodsInfoHandler;
import com.loevc.celestia.admin.pipeline.handlers.orderinfo.CreateOrderHandler;
import com.loevc.celestia.admin.pipeline.handlers.orderinfo.InitialOrderInfoParamHandler;
import com.loevc.celestia.admin.pipeline.handlers.orderinfo.SaveCacheHandler;
import com.loevc.celestia.admin.pipeline.handlers.orderinfo.SolveFinishedOrderHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class PipelineRouteConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static final int INIT_CAPACITY = 8;

    private static final Map<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>>
            PIPELINE_ROUTE_MAP = new HashMap<>(INIT_CAPACITY);


    // TODO 回溯算法 + 加权有向图
    static {
        PIPELINE_ROUTE_MAP.put(OrderInfoContext.class, Arrays.asList(
                InitialOrderInfoParamHandler.class,
                CreateOrderHandler.class,
                SolveFinishedOrderHandler.class
//                SaveCacheHandler.class));
                ));
        PIPELINE_ROUTE_MAP.put(GoodsInfoContext.class, Arrays.asList(
                InitialGoodsInfoHandler.class,
                DeleteGoodsInfoHandler.class));

    }

    @Bean("pipelineRouteMap")
    public Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>> getHandlerPipelineMap(){
        return PIPELINE_ROUTE_MAP.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, this::getPipeline));
    }

    private List<? extends ContextHandler<? extends PipelineContext>> getPipeline(Map.Entry<Class<? extends PipelineContext>,
            List<Class<? extends ContextHandler<? extends PipelineContext>>>> entry){
        return entry.getValue().stream().map(applicationContext::getBean).collect(Collectors.toList());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
