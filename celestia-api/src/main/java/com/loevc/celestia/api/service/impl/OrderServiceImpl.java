package com.loevc.celestia.api.service.impl;

import com.loevc.celestia.api.message.UserMessage;
import com.loevc.celestia.api.service.OrderService;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/9/6 9:34
 * @Description TODO
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {


    @Override
    public String getOrderId() {
        UserMessage userMessage = new UserMessage();
        userMessage.setId("1");
        userMessage.setName("lucas");
        return userMessage.getName();
    }
}
