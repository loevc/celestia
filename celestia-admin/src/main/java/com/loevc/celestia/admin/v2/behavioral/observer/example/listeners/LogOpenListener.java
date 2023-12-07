package com.loevc.celestia.admin.v2.behavioral.observer.example.listeners;

import java.io.File;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:16
 * @Description TODO
 * @Version 1.0
 */
public class LogOpenListener implements EventListener{

    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}
