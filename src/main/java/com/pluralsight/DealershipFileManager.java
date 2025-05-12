package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DealershipFileManager {

    public Dealership getDealership() {
        String fileName = "inventory.csv";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufRead = new BufferedReader(fileReader);

            String line = bufRead.readLine();
            System.out.println("First line: " + line);

            while ((line = bufRead.readLine()) != null) {
                System.out.println(line);
            }  // ✅ CLOSE YOUR WHILE LOOP

            bufRead.close();  // ✅ OUTSIDE the while loop

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong while reading the file.");
            e.printStackTrace();
        }

        return null;
    }



//    public void getDealership{
//        System.out.println("Getting Dealership info");
//    }
}
