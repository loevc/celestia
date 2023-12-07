package com.loevc.celestia.admin.v2.behavioral.visitor.example.shapes;

import com.loevc.celestia.admin.v2.behavioral.visitor.example.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:38
 * @Description TODO
 * @Version 1.0
 */
public class CompoundShape implements Shape{

    public int id;
    public List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

    public int getId() {
        return id;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(Shape shape) {
        children.add(shape);
    }
}
