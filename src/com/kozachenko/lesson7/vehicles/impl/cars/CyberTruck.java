package com.kozachenko.lesson7.vehicles.impl.cars;

public class CyberTruck extends Truck {
    private String mark;
    private String model;

    public CyberTruck() {
        System.out.println("Phase 1 default constructor");
    }

    public CyberTruck(String mark){
        System.out.println("Phase 2 CyberTruck(String mark) constructor");
        this.mark = mark;
    }

    public CyberTruck (String mark, String model){
        this(mark);
        System.out.println("Phase 3 CyberTruck (String mark, String model)");
        this.model = model;
    }



    public void electricMove(){
        System.out.printf("I am ElectricTruck %s %s",this.mark, this.model);
        move("Highway");
    }

    @Override
    public void move() {
        electricMove();
    }
}
