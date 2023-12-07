package com.loevc.celestia.admin.v2.behavioral.visitor.example.shapes;

import com.loevc.celestia.admin.v2.behavioral.visitor.example.visitor.Visitor;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:36
 * @Description TODO
 * @Version 1.0
 */
public class Circle extends Dot{
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }

    public int getRadius() {
        return radius;
    }

}
