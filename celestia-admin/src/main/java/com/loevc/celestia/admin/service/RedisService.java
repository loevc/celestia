package com.loevc.celestia.admin.service;

import java.util.concurrent.TimeUnit;

/**
 * @Author caijiliu
 * @Email L13831467435@163.com
 * @Date 2023/10/10 18:17
 * @Description
 * @Version 1.0
 */
public interface RedisService {
    void setValue(String key, String value);
    void  setValueWithTTL(String key, String value, long timeout, TimeUnit timeUnit);
    String getValue(String key);
    void  deleteValue(String key);
}
