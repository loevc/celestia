package com.loevc.celestia.admin.v2.creational.prototype.example.shapes;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:52
 * @Description TODO
 * @Version 1.0
 */
public class Circle extends Shape{

    public int radius;

    public Circle(){

    }


    public Circle(Circle target){
        super(target);
        if (target != null){
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}
