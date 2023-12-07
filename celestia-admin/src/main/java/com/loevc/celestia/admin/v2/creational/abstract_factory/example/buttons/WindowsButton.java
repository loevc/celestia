package com.loevc.celestia.admin.v2.creational.abstract_factory.example.buttons;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 14:55
 * @Description TODO
 * @Version 1.0
 */
public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
