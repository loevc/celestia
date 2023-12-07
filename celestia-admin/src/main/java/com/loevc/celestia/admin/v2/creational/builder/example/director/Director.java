package com.loevc.celestia.admin.v2.creational.builder.example.director;

import com.loevc.celestia.admin.v2.creational.builder.example.builders.Builder;
import com.loevc.celestia.admin.v2.creational.builder.example.cars.CarType;
import com.loevc.celestia.admin.v2.creational.builder.example.components.Engine;
import com.loevc.celestia.admin.v2.creational.builder.example.components.GPSNavigator;
import com.loevc.celestia.admin.v2.creational.builder.example.components.Transmission;
import com.loevc.celestia.admin.v2.creational.builder.example.components.TripComputer;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:36
 * @Description TODO
 * @Version 1.0
 */
public class Director {

    public void constructSportsCar(Builder builder){
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder){
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder){
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
