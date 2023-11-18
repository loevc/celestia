package com.loevc.celestia.admin.pipeline.context;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PipelineContext {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public String getName(){
        return this.getClass().getSimpleName();
    }
}
