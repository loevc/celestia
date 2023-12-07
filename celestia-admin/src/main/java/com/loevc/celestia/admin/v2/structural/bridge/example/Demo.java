package com.loevc.celestia.admin.v2.structural.bridge.example;

import com.loevc.celestia.admin.v2.structural.bridge.example.devices.Device;
import com.loevc.celestia.admin.v2.structural.bridge.example.devices.Radio;
import com.loevc.celestia.admin.v2.structural.bridge.example.devices.Tv;
import com.loevc.celestia.admin.v2.structural.bridge.example.remotes.AdvancedRemote;
import com.loevc.celestia.admin.v2.structural.bridge.example.remotes.BasicRemote;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 18:06
 * @Description TODO
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
