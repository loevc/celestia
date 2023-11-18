package com.loevc.celestia.admin.pipeline.handlers.orderinfo;

import cn.hutool.json.JSONUtil;
import com.loevc.celestia.admin.pipeline.handlers.ContextHandler;
import com.loevc.celestia.common.entity.OrderInfo;
import com.loevc.celestia.admin.pipeline.context.orderinfo.OrderInfoContext;
import com.loevc.celestia.common.constant.RedisConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@Slf4j
//@Component
@AllArgsConstructor
public class SaveCacheHandler implements ContextHandler<OrderInfoContext> {

    // TODO  注意这个地方 传入泛型 会影响其他Bean中RedisTemplate注入
    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean handle(OrderInfoContext context) {
        log.info("exec order info cached --> ");
        syncOrderStatus2Cache(JSONUtil.toJsonStr(context), Optional.ofNullable(context.getOrderInfo()).orElse(new OrderInfo(){{setId("-1");}}).getId());
        return true;
    }

    private void syncOrderStatus2Cache(String jsonStr, String orderId) {
        long expire = LocalDateTime.now().until(LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0), ChronoUnit.MILLIS);
        redisTemplate.opsForValue().set(RedisConstants.getKey(RedisConstants.ORDER_STAT, "TenantContextHolder.getTenantId()", orderId),
                jsonStr, expire, TimeUnit.MILLISECONDS);
    }
}
