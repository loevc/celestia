package com.loevc.celestia.admin.v2.creational.builder.example.components;

import com.loevc.celestia.admin.v2.creational.builder.example.cars.Car;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:33
 * @Description TODO
 * @Version 1.0
 */
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel(){
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus(){
        if (this.car.getEngine().isStarted()){
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
