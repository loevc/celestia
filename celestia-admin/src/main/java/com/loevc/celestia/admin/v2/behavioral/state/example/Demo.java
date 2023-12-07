package com.loevc.celestia.admin.v2.behavioral.state.example;

import com.loevc.celestia.admin.v2.behavioral.state.example.ui.Player;
import com.loevc.celestia.admin.v2.behavioral.state.example.ui.UI;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:25
 * @Description TODO
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
