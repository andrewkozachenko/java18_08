package com.kozachenko.lesson14;

interface Lambda{
    int calculate(int x, int y);
}

public class Main {
    public static void main(String[] args) throws ArraysCompareException {
//        int a [] = {543510, 10, 6,-3, 25, 23, 17};
//        int b [] = {32, 10, -6,3, 25, 23, 17};
//        CompareArrays compareArrays = new CompareArrays();
//        Integer[] array = compareArrays.getSimilarMapVersion(a, b);
//        System.out.println(array);

        Lambda lambda = new Lambda() {
            @Override
            public int calculate(int x, int y) {
                return 0;
            }
        };
        Lambda lambda1 = (x, y) -> x+y;
        System.out.println(lambda.calculate(3,4));
        System.out.println(lambda1.calculate(3,4));
    }
}
