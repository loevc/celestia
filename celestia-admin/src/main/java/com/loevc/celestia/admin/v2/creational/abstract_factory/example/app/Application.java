package com.loevc.celestia.admin.v2.creational.abstract_factory.example.app;

import com.loevc.celestia.admin.v2.creational.abstract_factory.example.buttons.Button;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.checkboxes.Checkbox;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.factories.GUIFactory;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:04
 * @Description TODO
 * @Version 1.0
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
