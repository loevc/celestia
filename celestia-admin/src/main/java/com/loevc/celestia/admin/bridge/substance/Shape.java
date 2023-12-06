package com.loevc.celestia.admin.bridge.substance;

import com.loevc.celestia.admin.bridge.action.Color;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/5 15:26
 * @Description TODO
 * @Version 1.0
 */
public abstract class Shape {

    protected String name;

    protected Color color;

    public String getName() {
        return name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
