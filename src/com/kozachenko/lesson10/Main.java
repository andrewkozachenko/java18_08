package com.kozachenko.lesson10;

public class Main {
    public static void main(String[] args) {
//        int i  = 10;
//        Integer I = i;
//        byte b = 64;
//        i = b;
//        byte b =(byte) i;
        int i = 2000000000;
        byte b =(byte) i;
        int f = 127;
        byte d =(byte) f;
        short t = d;
        Short ddt =(short) d;
        System.out.println(i);
        System.out.println(b);
        System.out.println(f);
        System.out.println(d);
    }
}
