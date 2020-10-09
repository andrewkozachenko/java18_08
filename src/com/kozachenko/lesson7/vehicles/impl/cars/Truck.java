package com.kozachenko.lesson7.vehicles.impl.cars;

import com.kozachenko.lesson7.vehicles.impl.Car;

public class Truck extends Car {

    public Truck() {
        System.out.println("Phase 0");
    }

    @Override
    public void move() {
        drive();
    }

    @Override
    public void drive() {
        System.out.println("I drive this Truck");
    }

    public void move(String direction){
        System.out.println(" I move to " + direction);
        drive();
    }
}
