package com.loevc.celestia.admin.v2.creational.builder.example.components;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:30
 * @Description TODO
 * @Version 1.0
 */
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }


    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
