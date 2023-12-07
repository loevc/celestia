package com.loevc.celestia.admin.v2.creational.prototype.example.shapes;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:55
 * @Description TODO
 * @Version 1.0
 */
public class Rectangle extends Shape{

    public int width;

    public int height;

    public Rectangle(){

    }

    public Rectangle(Rectangle target){
        super(target);
        if (target != null){
            this.width = target.width;
            this.height = target.height;
        }
    }



    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}
