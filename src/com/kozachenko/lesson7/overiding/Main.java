package com.kozachenko.lesson7.overiding;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        B c = new C();

        a.a();
        b.a();
        c.a();
    }
}
