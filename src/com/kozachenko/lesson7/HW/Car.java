package com.kozachenko.lesson7.HW;

public class Car implements PrintingInfo{
    private Driver driver;
    private Engine engine;



    public Car(Driver driver, Engine engine) {
        this.driver = driver;
        this.engine = engine;
    }

    public void printInfo(){
        System.out.println("Mark2");
        driver.printInfo();
        engine.printInfo();
    }
}
