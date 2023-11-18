package com.loevc.celestia.admin.pipeline;

import cn.hutool.core.collection.CollUtil;
import com.loevc.celestia.admin.pipeline.context.PipelineContext;
import com.loevc.celestia.admin.pipeline.handlers.ContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class PipelineExecutor {


    @Resource
    private Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap;

    public boolean acceptSync(PipelineContext context){
        Objects.requireNonNull(context,"context cannot be null");
        Class<? extends PipelineContext> dataType = context.getClass();
        List<? extends ContextHandler<? super PipelineContext>> contextHandlers = pipelineRouteMap.get(dataType);
        if (CollUtil.isEmpty(contextHandlers)){
            log.error("{} 's pipeline is null", dataType.getSimpleName());
            return false;
        }

        boolean executeStatus = true;
        for (ContextHandler<? super PipelineContext> contextHandler : contextHandlers) {
            try {
                executeStatus = contextHandler.handle(context);
            } catch (Throwable ex){
                executeStatus = false;
                log.error("{} execute exception , handler={}",context.getName(), contextHandler.getClass().getSimpleName(), ex);
            }
            if (!executeStatus){
                break;
            }
        }

        return executeStatus;
    }

}
