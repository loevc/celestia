package com.loevc.cloud.celestia.common.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/11 15:29
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class MongodbConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initIndexed(){
        mongoTemplate.indexOps("celestia")
                .ensureIndex(new Index().on("email", Sort.Direction.ASC));
    }
}
