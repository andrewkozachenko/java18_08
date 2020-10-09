package com.kozachenko.lesson7.HW;

public class Driver implements PrintingInfo{
    private String name ;

    public Driver(String name) {
        this.name = name;
    }

    @Override
    public void printInfo() {
        System.out.println("My name is " + name);
    }
}
