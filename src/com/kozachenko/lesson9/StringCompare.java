package com.kozachenko.lesson9;

public class StringCompare {
    public static void main(String[] args) {
        String s = "hello";
        String s2 = new String("hello");
        String s3 = "hello";
        System.out.println(s.equals(s2));
        System.out.println(s == s2);
        System.out.println(s == s3);

        System.out.println("#############################");

        StringBuffer stringBuffer = new StringBuffer("hello");
        StringBuffer stringBuffer2 = new StringBuffer("hello");
        System.out.println(stringBuffer.equals(stringBuffer2));

        System.out.println("#############################");

        String tr =  "Я имел сказать предложение";
        System.out.println(tr.substring(5));
        System.out.println(tr.substring(tr.indexOf(" ")));
        System.out.println(tr.substring(5, 10));

        System.out.println("#############################");

    }
}
