package com.loevc.celestia.admin.bridge.substance;

import lombok.Getter;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/5 15:44
 * @Description TODO
 * @Version 1.0
 */
@Getter
public class Rectangle extends Shape{

    String name = "Rectangle";

    @Override
    public void draw() {
        color.paint(this);
    }
}
