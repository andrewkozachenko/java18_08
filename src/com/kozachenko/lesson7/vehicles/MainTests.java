package com.kozachenko.lesson7.vehicles;

import com.kozachenko.lesson7.vehicles.impl.Car;
import com.kozachenko.lesson7.vehicles.impl.cars.CyberTruck;

public class MainTests {

    public static void main(String[] args) {
//        Truck tnt = new Truck();
//        Truck tnt1 = new Car();
//        Car car = new Truck();
        Car electricCar = new CyberTruck();
        CyberTruck eC = (CyberTruck) electricCar;
        CyberTruck cyberTruck = new CyberTruck("Tesla", "CyberTruck");
//        electricCar.drive();
//        cyberTruck.electricMove();
        cyberTruck.move();

    }
}
