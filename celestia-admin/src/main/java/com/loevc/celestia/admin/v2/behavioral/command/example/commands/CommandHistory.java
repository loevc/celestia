package com.loevc.celestia.admin.v2.behavioral.command.example.commands;

import java.util.Stack;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:14
 * @Description TODO
 * @Version 1.0
 */
public class CommandHistory {

    private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }

}
