package com.loevc.celestia.admin.v2.behavioral.visitor.example.shapes;

import com.loevc.celestia.admin.v2.behavioral.visitor.example.visitor.Visitor;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:36
 * @Description
 * @Version 1.0
 */
public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
