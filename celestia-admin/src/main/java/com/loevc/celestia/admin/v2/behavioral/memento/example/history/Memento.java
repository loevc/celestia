package com.loevc.celestia.admin.v2.behavioral.memento.example.history;

import com.loevc.celestia.admin.v2.behavioral.memento.example.editor.Editor;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:57
 * @Description TODO
 * @Version 1.0
 */
public class Memento {
    private String backup;
    private Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}
