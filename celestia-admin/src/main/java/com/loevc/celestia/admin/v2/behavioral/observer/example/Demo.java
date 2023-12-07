package com.loevc.celestia.admin.v2.behavioral.observer.example;

import com.loevc.celestia.admin.v2.behavioral.observer.example.editor.Editor;
import com.loevc.celestia.admin.v2.behavioral.observer.example.listeners.EmailNotificationListener;
import com.loevc.celestia.admin.v2.behavioral.observer.example.listeners.LogOpenListener;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:16
 * @Description TODO
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
