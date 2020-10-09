package com.kozachenko.lesson11;

public class Main {
    public static void main(String[] args) {
        Food<Float> food = new Food<Float>() {
            @Override
            public Float getAmount() {
                return null;
            }
        };
        Food<Float> f = new Apple();
        Apple a = (Apple)f;
        ((Apple)f).setAmount(3.4f);
    }
}
