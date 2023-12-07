package com.loevc.celestia.admin.v2.behavioral.memento.example.editor;


import com.loevc.celestia.admin.v2.behavioral.memento.example.commands.Command;
import com.loevc.celestia.admin.v2.behavioral.memento.example.history.History;
import com.loevc.celestia.admin.v2.behavioral.memento.example.history.Memento;
import com.loevc.celestia.admin.v2.behavioral.memento.example.shapes.CompoundShape;
import com.loevc.celestia.admin.v2.behavioral.memento.example.shapes.Shape;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:54
 * @Description TODO
 * @Version 1.0
 */
public class Editor extends JComponent {

    private Canvas canvas;
    private CompoundShape allShapes = new CompoundShape();
    private History history;

    public Editor() {
        canvas = new Canvas(this);
        history = new History();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    public CompoundShape getShapes() {
        return allShapes;
    }

    public void execute(Command c) {
        history.push(c, new Memento(this));
        c.execute();
    }

    public void undo() {
        if (history.undo())
            canvas.repaint();
    }

    public void redo() {
        if (history.redo())
            canvas.repaint();
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.print("ClassNotFoundException occurred.");
        } catch (IOException e) {
            System.out.print("IOException occurred.");
        }
    }

}
