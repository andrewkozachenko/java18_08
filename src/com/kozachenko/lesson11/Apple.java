package com.kozachenko.lesson11;

public class Apple<T> implements Food<T> {
    private T amount;
    @Override
    public T getAmount() {
        return null;
    }

    public void setAmount(T amount) {
        this.amount = amount;
    }
}
