package com.loevc.celestia.admin.v2.behavioral.command.example.commands;

import com.loevc.celestia.admin.v2.behavioral.command.example.editor.Editor;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:12
 * @Description TODO
 * @Version 1.0
 */
public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
