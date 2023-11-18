package com.loevc.celestia.admin.pipeline.context.orderinfo;

import com.loevc.celestia.admin.pipeline.context.PipelineContext;
import com.loevc.celestia.common.entity.OrderInfo;
import lombok.Data;

@Data
public class OrderInfoContext extends PipelineContext {


    private String tempStatus;


    private OrderInfo orderInfo;

    @Override
    public String getName() {
        return "<order_info> context";
    }
}
