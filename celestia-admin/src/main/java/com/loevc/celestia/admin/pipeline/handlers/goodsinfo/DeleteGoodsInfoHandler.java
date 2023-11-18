package com.loevc.celestia.admin.pipeline.handlers.goodsinfo;

import com.loevc.celestia.admin.pipeline.context.goodsinfo.GoodsInfoContext;
import com.loevc.celestia.admin.pipeline.context.orderinfo.OrderInfoContext;
import com.loevc.celestia.admin.pipeline.handlers.ContextHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/17 16:07
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Component
@AllArgsConstructor
public class DeleteGoodsInfoHandler implements ContextHandler<GoodsInfoContext> {


    @Override
    public boolean handle(GoodsInfoContext context) {
        log.info("exec goods info deleted --> ");
        return true;
    }
}
