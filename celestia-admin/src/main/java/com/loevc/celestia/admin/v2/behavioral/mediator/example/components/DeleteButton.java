package com.loevc.celestia.admin.v2.behavioral.mediator.example.components;

import com.loevc.celestia.admin.v2.behavioral.mediator.example.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:39
 * @Description TODO
 * @Version 1.0
 */
public class DeleteButton extends JButton implements Component {

    private Mediator mediator;

    public DeleteButton() {
        super("Del");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.deleteNote();
    }

    @Override
    public String getName() {
        return "DelButton";
    }
}
