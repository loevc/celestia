package com.loevc.cloud.celestia.admin.service.impl;

import com.loevc.cloud.celestia.admin.service.MongodbOperateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/11 14:00
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class MongodbOperateServiceImpl implements MongodbOperateService {

    private final MongoTemplate mongoTemplate;


    @Override
    public Object saveObj(Object obj, String collectionName) {
        return mongoTemplate.insert(obj, collectionName);
    }
}
