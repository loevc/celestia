package com.loevc.celestia.admin.v2.creational.abstract_factory.example.factories;

import com.loevc.celestia.admin.v2.creational.abstract_factory.example.buttons.Button;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.buttons.WindowsButton;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.checkboxes.Checkbox;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.checkboxes.WindowsCheckbox;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:03
 * @Description TODO
 * @Version 1.0
 */
public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
