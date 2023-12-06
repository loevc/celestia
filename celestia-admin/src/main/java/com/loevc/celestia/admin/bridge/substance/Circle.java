package com.loevc.celestia.admin.bridge.substance;

import com.loevc.celestia.admin.bridge.action.Black;
import lombok.Getter;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/5 15:42
 * @Description TODO
 * @Version 1.0
 */
@Getter
public class Circle extends Shape{

    String name = "Circle";

    @Override
    public void draw() {
        color.paint(this);
    }
}
