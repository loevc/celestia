package com.loevc.cloud.celestia.admin.service;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/11 13:59
 * @Description
 * @Version 1.0
 */
public interface MongodbOperateService<T> {

    T saveObj(T obj, String collectionName);
}
