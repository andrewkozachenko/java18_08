package com.kozachenko.lesson22.multithreading;

public class SimpleThreads extends Thread {
    private static int threadCount = 0;
    private int countDown = 5, threadNum = ++threadCount;
    public SimpleThreads() {
        System.out.println("Making " + threadNum);
    }
    public void run() {
        while(true) {
            System.out.println("Thread " +         threadNum + "(" + countDown + ")");
            if(--countDown == 0) return;
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new SimpleThreads().start();
        System.out.println("All Threads Started");
        System.out.println("All Threads Done");
    }
}

