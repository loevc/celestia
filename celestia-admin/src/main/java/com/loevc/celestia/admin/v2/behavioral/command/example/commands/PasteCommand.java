package com.loevc.celestia.admin.v2.behavioral.command.example.commands;

import com.loevc.celestia.admin.v2.behavioral.command.example.editor.Editor;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:13
 * @Description TODO
 * @Version 1.0
 */
public class PasteCommand extends Command {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
