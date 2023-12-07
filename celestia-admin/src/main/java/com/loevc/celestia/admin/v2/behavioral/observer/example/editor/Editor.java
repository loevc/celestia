package com.loevc.celestia.admin.v2.behavioral.observer.example.editor;

import com.loevc.celestia.admin.v2.behavioral.observer.example.publisher.EventManager;

import java.io.File;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:14
 * @Description TODO
 * @Version 1.0
 */
public class Editor {

    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
