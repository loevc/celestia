package com.loevc.celestia.admin.v2.behavioral.command.example.commands;

import com.loevc.celestia.admin.v2.behavioral.command.example.editor.Editor;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:13
 * @Description TODO
 * @Version 1.0
 */
public class CopyCommand extends Command{
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
