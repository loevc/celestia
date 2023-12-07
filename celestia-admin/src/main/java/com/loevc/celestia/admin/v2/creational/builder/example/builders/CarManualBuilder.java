package com.loevc.celestia.admin.v2.creational.builder.example.builders;

import com.loevc.celestia.admin.v2.creational.builder.example.cars.CarType;
import com.loevc.celestia.admin.v2.creational.builder.example.cars.Manual;
import com.loevc.celestia.admin.v2.creational.builder.example.components.Engine;
import com.loevc.celestia.admin.v2.creational.builder.example.components.GPSNavigator;
import com.loevc.celestia.admin.v2.creational.builder.example.components.Transmission;
import com.loevc.celestia.admin.v2.creational.builder.example.components.TripComputer;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:15
 * @Description TODO
 * @Version 1.0
 */
public class CarManualBuilder implements Builder{
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult(){
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }

}
