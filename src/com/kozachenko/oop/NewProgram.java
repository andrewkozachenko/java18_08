package com.kozachenko.oop;

public class NewProgram {
    public static void main(String[] args) {
        int k, i, j, n = 8;
        int star, hash;
        star = 1;
        hash = n - 1;
//        hash = n;
        for (k = 0; k < n; k++) {
            if (k % 2 == 0) {
                for (i = 1; i <= star; i++) {
                    System.out.print("*");
                }
                for (j = 1; j <= hash; j++) {
                    System.out.print("#");
                }
            } else {
                for (i = 1; i <= hash; i++) {
                    System.out.print("#");
                }
                for (j = 1; j <= star; j++) {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
            if (k < n / 2) {
                star++;
                hash--;
            } else {
                star--;
                hash++;
            }
        }
    }
}
