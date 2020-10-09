package com.kozachenko.oop;

import java.io.*;
import java.util.*;

class Solution {
    public void solution(int X,int Y){
        //
        // write your logic here and print the desired output
        //
        int max = Math.max(X,Y);
        if((Y == (X+1)) || (X == (Y+1)) || (Y == X)){
            System.out.println(0);
        } else if(max == Y){
            Y = Y - (X+1);
            System.out.println(Y);
        } else if (max == X){
            X = X - (Y+1);
            System.out.println(X);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        Solution s = new Solution();
        s.solution(X,Y);
    }
}
