package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class DealershipFileManager {
//????
    public Dealership getDealership() {
        //    Scanner scanner = new Scanner(System.in);
        String fileName = "inventory.csv";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufRead = new BufferedReader(fileReader);
            // read lines here
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
        }

    }
