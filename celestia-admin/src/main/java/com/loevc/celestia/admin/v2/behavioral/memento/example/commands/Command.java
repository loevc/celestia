package com.loevc.celestia.admin.v2.behavioral.memento.example.commands;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:58
 * @Description TODO
 * @Version 1.0
 */
public interface Command {
    String getName();
    void execute();
}
