package com.loevc.celestia.admin.v2.creational.factory_method.example.factory;

import com.loevc.celestia.admin.v2.creational.factory_method.example.buttons.Button;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 14:47
 * @Description TODO
 * @Version 1.0
 */
public abstract class Dialog {

    public void renderWindow(){

        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
