package com.loevc.celestia.admin.v2.creational.factory_method.example.factory;

import com.loevc.celestia.admin.v2.creational.factory_method.example.buttons.Button;
import com.loevc.celestia.admin.v2.creational.factory_method.example.buttons.WindowsButton;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 14:50
 * @Description TODO
 * @Version 1.0
 */
public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
