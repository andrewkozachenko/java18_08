package com.kozachenko.lesson9;

import java.util.Arrays;

public class Lesson {
    public static void main(String[] args) {
        String s = "Lemon School";
        printOut(s);

        int array [] = {1, 2};
        int array3 [] = new int[10];
        int matrix [][] = new int[8][8];
        int matrix3 [][] [] = new int[2][3][8];

        StringBuilder stringBuilder = new StringBuilder();
        String result = "Summa"
                + " ravna ".trim()
                + "15";
        stringBuilder.append("Summa").append("=").append(15);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Znachenia").append(1232);
        System.out.println(stringBuilder.toString());

        System.out.println("ddd" + "##"+getChar(result, 5)+"##");


    }


    static void printOut(String s){
        System.out.println(s);
    }


    static char getChar(String s, int index){
        return s.charAt(index);
    }


    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
