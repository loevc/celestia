package com.loevc.celestia.admin.v2.creational.builder.example.builders;

import com.loevc.celestia.admin.v2.creational.builder.example.cars.CarType;
import com.loevc.celestia.admin.v2.creational.builder.example.components.Engine;
import com.loevc.celestia.admin.v2.creational.builder.example.components.GPSNavigator;
import com.loevc.celestia.admin.v2.creational.builder.example.components.Transmission;
import com.loevc.celestia.admin.v2.creational.builder.example.components.TripComputer;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 15:08
 * @Description
 * @Version 1.0
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
