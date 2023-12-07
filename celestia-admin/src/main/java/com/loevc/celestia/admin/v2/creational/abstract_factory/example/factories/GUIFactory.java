package com.loevc.celestia.admin.v2.creational.abstract_factory.example.factories;

import com.loevc.celestia.admin.v2.creational.abstract_factory.example.buttons.Button;
import com.loevc.celestia.admin.v2.creational.abstract_factory.example.checkboxes.Checkbox;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 14:59
 * @Description
 * @Version 1.0
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
