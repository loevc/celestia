package com.loevc.celestia.admin.pipeline.context.goodsinfo;

import com.loevc.celestia.admin.pipeline.context.PipelineContext;
import com.loevc.celestia.common.entity.GoodsInfo;
import com.loevc.celestia.common.entity.OrderInfo;
import lombok.Data;

@Data
public class GoodsInfoContext extends PipelineContext {


    private String tempStatus;


    private GoodsInfo goodsInfo;

    @Override
    public String getName() {
        return "<goods_info> context";
    }
}
