package com.loevc.celestia.admin.pipeline.handlers;


import com.loevc.celestia.admin.pipeline.context.PipelineContext;

public interface ContextHandler<T extends PipelineContext>{

    boolean handle(T context);
}
