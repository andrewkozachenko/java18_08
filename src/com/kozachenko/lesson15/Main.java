package com.kozachenko.lesson15;

import com.kozachenko.lesson15.calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Calculator calculator = new Calculator();

        System.out.println(calculator.calculate(s));
    }
}
