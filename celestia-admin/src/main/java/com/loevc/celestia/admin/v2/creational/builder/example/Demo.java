package com.loevc.celestia.admin.v2.creational.builder.example;

import com.loevc.celestia.admin.v2.creational.builder.example.builders.CarBuilder;
import com.loevc.celestia.admin.v2.creational.builder.example.builders.CarManualBuilder;
import com.loevc.celestia.admin.v2.creational.builder.example.cars.Car;
import com.loevc.celestia.admin.v2.creational.builder.example.cars.Manual;
import com.loevc.celestia.admin.v2.creational.builder.example.director.Director;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:44
 * @Description TODO
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
