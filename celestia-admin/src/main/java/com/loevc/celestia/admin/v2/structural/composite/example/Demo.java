package com.loevc.celestia.admin.v2.structural.composite.example;

import com.loevc.celestia.admin.v2.structural.composite.example.editor.ImageEditor;
import com.loevc.celestia.admin.v2.structural.composite.example.shapes.Circle;
import com.loevc.celestia.admin.v2.structural.composite.example.shapes.CompoundShape;
import com.loevc.celestia.admin.v2.structural.composite.example.shapes.Dot;
import com.loevc.celestia.admin.v2.structural.composite.example.shapes.Rectangle;

import java.awt.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 18:18
 * @Description TODO
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

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
