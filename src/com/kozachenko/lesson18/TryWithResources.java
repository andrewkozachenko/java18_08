package com.kozachenko.lesson18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) {

    }

    private static void withTryCatchFinaly(String fileName){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void withTryWithResources(String fileName){
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    private static void tryWithMultipleResources(String srcFile, String dstFile) throws IOException {
        try (Scanner scanner = new Scanner(new File(srcFile));
             PrintWriter writer = new PrintWriter(new File(dstFile))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }
    }
}
