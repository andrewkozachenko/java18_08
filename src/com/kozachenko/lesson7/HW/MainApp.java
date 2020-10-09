package com.kozachenko.lesson7.HW;

public class MainApp {
    public static void main(String[] args) {
        Driver driver = new Driver("Iron Man");
        Engine engine = new Engine("Gas");
        Car newCar = new Car(driver, engine);
        newCar.printInfo();
    }
}
