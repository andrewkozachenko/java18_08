package com.kozachenko.lesson18;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {
        String fileName = "input_file.txt";
    }

    private static void scannerRead(String fileName) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void fileReader(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            int i;
            while ((i=fr.read()) != -1){
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void bufferedReader(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

