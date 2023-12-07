package com.loevc.celestia.admin.v2.structural.bridge.example.remotes;

import com.loevc.celestia.admin.v2.structural.bridge.example.devices.Device;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 18:05
 * @Description TODO
 * @Version 1.0
 */
public class AdvancedRemote extends BasicRemote{

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }

}
