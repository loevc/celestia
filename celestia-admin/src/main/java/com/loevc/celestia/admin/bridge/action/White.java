package com.loevc.celestia.admin.bridge.action;

import com.loevc.celestia.admin.bridge.substance.Shape;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/5 15:37
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class White implements Color{

    String name = "white";

    @Override
    public void paint(Shape shape) {
        log.info("{} {}", name, shape.getName());
    }
}
