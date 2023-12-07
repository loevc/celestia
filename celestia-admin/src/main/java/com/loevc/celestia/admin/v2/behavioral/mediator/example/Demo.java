package com.loevc.celestia.admin.v2.behavioral.mediator.example;

import com.loevc.celestia.admin.v2.behavioral.mediator.example.components.*;
import com.loevc.celestia.admin.v2.behavioral.mediator.example.mediator.Editor;
import com.loevc.celestia.admin.v2.behavioral.mediator.example.mediator.Mediator;

import javax.swing.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:49
 * @Description TODO
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
