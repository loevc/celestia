package com.loevc.celestia.admin.v2.behavioral.memento.example.commands;

import com.loevc.celestia.admin.v2.behavioral.memento.example.editor.Editor;
import com.loevc.celestia.admin.v2.behavioral.memento.example.shapes.Shape;

import java.awt.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:59
 * @Description TODO
 * @Version 1.0
 */
public class ColorCommand implements Command{

    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
