package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;
        String fileName = "newInventory.csv";
        try (BufferedReader bufRead = new BufferedReader(new FileReader(fileName))) {
            String line;
            bufRead.readLine();
            while ((line = bufRead.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {

                    String name = parts[0];
                    String address = parts[1];
                    String phoneNumber = parts[2];


                    if (dealership == null) {
                        dealership = new Dealership(name, address, phoneNumber);
                    }
                } else if (parts.length > 3) {

                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int mileage = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);

                    if (dealership != null) {
                        dealership.addVehicle(vehicle);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }






    public static void saveDealership(Dealership dealership) {
     ArrayList<Dealership> saved = new ArrayList<>();

    {
        try (FileWriter fw = new FileWriter("newInventory.csv");
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String name = dealership.getName();
                String address = dealership.getAddress();
                String phoneNumber = dealership.getPhone();
                out.println(name + " | " + address + " | " + phoneNumber);
                String vehicleDetails = String.format("vin=%s | year=%d | make='%s'| model='%s'| vehicleType='%s'| color='%s'| mileage=%d| price=%.2f",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getMileage(), vehicle.getPrice());
                out.println(vehicleDetails);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }



   }

}
-m " "