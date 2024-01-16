package com.loevc.cloud.celestia.admin.drools.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2024/1/16 16:17
 * @Description TODO
 * @Version 1.0
 */
@Data
public class Order {

    private BigDecimal originalPrice;

    private BigDecimal realPrice;
}
