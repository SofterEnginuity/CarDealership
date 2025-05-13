package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = new Dealership("Pluralsight Motors", "123 Main St", "555-1234");
        String fileName = "newInventory.csv";
        try (BufferedReader bufRead = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufRead.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 8) continue;

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int mileage = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);
                dealership.addVehicle(vehicle);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }



}
