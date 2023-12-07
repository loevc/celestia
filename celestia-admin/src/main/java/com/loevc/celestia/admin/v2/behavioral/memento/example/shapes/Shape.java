package com.loevc.celestia.admin.v2.behavioral.memento.example.shapes;

import java.awt.*;
import java.io.Serializable;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:01
 * @Description TODO
 * @Version 1.0
 */
public interface Shape extends Serializable {

    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void drag();
    void drop();
    void moveTo(int x, int y);
    void moveBy(int x, int y);
    boolean isInsideBounds(int x, int y);
    Color getColor();
    void setColor(Color color);
    void select();
    void unSelect();
    boolean isSelected();
    void paint(Graphics graphics);
}
