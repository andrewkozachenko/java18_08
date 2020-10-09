package com.kozachenko.lesson7.HW;

public class Engine implements PrintingInfo {
    private String name;

    public Engine(String name) {
        this.name = name;
    }

    @Override
    public void printInfo() {
        System.out.println("My name is " + name);
    }
}
