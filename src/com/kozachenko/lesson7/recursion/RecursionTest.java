package com.kozachenko.lesson7.recursion;

public class RecursionTest {

    public static int factorial(int n){
        if(n<2){
            return 1;
        }
        return n * factorial(n-1);
    }

    public int factorial2(int n){
        if(n<2){
            return 1;
        }
        return n * factorial2(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
