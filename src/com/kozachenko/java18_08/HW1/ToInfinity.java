package com.kozachenko.java18_08.HW1;

public class ToInfinity {
    public static void main(String[] args) {

//впишите код сюда
        int start = Integer.MAX_VALUE - 1;

        for (int i = start; i <= start + 1; i++) {
            /* тут должен быть бесконечный цикл, менять ничего нельзя*/
            System.out.println(start);
            ++start;

        }
    }
}
