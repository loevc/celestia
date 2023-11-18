package com.loevc.celestia.admin.pipeline.handlers.orderinfo;

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
public class CreateOrderHandler implements ContextHandler<OrderInfoContext> {


    @Override
    public boolean handle(OrderInfoContext context) {
        log.info("exec order info created  --> ");
        return false;
    }
}
