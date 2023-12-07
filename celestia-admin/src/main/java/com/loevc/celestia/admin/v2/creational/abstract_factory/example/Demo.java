package com.loevc.celestia.admin.v2.creational.abstract_factory.example;

import com.loevc.celestia.admin.v2.creational.abstract_factory.example.app.Application;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.factories.GUIFactory;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.factories.MacOSFactory;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.factories.WindowsFactory;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:05
 * @Description TODO
 * @Version 1.0
 */
public class Demo {

    private static Application configureApplication(){
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.equals("mac")){
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
