package com.loevc.celestia.admin.v2.behavioral.observer.example.listeners;

import java.io.File;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:14
 * @Description TODO
 * @Version 1.0
 */
public interface EventListener {
    void update(String eventType, File file);
}
