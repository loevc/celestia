package com.loevc.celestia.admin.v2.creational.factory_method.example;

import com.loevc.celestia.admin.v2.creational.factory_method.example.factory.Dialog;
import com.loevc.celestia.admin.v2.creational.factory_method.example.factory.HtmlDialog;
import com.loevc.celestia.admin.v2.creational.factory_method.example.factory.WindowsDialog;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 14:51
 * @Description TODO
 * @Version 1.0
 */
public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure(){
        if (System.getProperty("os.name").equals("Windows 10")){
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic(){
        dialog.renderWindow();
    }
}
