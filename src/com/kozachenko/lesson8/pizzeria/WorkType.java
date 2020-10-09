package com.kozachenko.lesson8.pizzeria;

public enum WorkType {
    COOK("Cooking"),
    GET_ORDER("Getting order"),
    SERVE("Serving"),
    CLOSE_ORDER("Closing order"),
    MAKE_DRINK("making drink");

    private String message;

    WorkType(String message) {
        this.message = message;
    }
}
