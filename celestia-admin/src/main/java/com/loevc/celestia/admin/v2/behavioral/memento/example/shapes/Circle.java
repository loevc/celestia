package com.loevc.celestia.admin.v2.behavioral.memento.example.shapes;


import java.awt.*;
/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:02
 * @Description TODO
 * @Version 1.0
 */
public class Circle extends BaseShape{

    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1);
    }
}
