package com.loevc.cloud.celestia.admin.liteflow;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2024/1/16 13:57
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Component("c")
public class CCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        log.info("cccc");
    }
}
