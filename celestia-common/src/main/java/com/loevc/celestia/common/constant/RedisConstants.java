package com.loevc.celestia.common.constant;


public class RedisConstants {

    private static final String BASE_KEY = "celestia:";

    public static final String ORDER_STAT = "order:stat:%s:%s";

    public static String getKey(String key, Object... objects){
        return BASE_KEY + String.format(key, objects);
    }
}
