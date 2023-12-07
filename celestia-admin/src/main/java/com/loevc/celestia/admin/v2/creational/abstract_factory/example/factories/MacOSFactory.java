package com.loevc.celestia.admin.v2.creational.abstract_factory.example.factories;

import com.loevc.celestia.admin.v2.creational.abstract_factory.example.buttons.Button;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.buttons.MacOSButton;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.checkboxes.Checkbox;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.checkboxes.MacOSCheckbox;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:02
 * @Description TODO
 * @Version 1.0
 */
public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
