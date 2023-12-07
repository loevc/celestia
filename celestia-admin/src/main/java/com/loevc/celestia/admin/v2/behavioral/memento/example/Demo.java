package com.loevc.celestia.admin.v2.behavioral.memento.example;

import com.loevc.celestia.admin.v2.behavioral.memento.example.editor.Editor;
import com.loevc.celestia.admin.v2.behavioral.memento.example.shapes.Circle;
import com.loevc.celestia.admin.v2.behavioral.memento.example.shapes.CompoundShape;
import com.loevc.celestia.admin.v2.behavioral.memento.example.shapes.Dot;
import com.loevc.celestia.admin.v2.behavioral.memento.example.shapes.Rectangle;

import java.awt.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:05
 * @Description TODO
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
