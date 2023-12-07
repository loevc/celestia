package com.loevc.celestia.admin.v2.behavioral.mediator.example.components;

import com.loevc.celestia.admin.v2.behavioral.mediator.example.mediator.Mediator;
import com.loevc.celestia.admin.v2.behavioral.mediator.example.mediator.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:38
 * @Description TODO
 * @Version 1.0
 */
public class AddButton extends JButton implements Component {

    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.addNewNote(new Note());
    }

    @Override
    public String getName() {
        return "AddButton";
    }

}
