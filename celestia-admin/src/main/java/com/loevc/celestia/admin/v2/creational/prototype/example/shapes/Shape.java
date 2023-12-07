package com.loevc.celestia.admin.v2.creational.prototype.example.shapes;

import java.util.Objects;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:47
 * @Description TODO
 * @Version 1.0
 */
public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape(){

    }

    public Shape(Shape target){
        if (target != null){
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }
}
