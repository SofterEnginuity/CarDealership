package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public void display() {
        init();
        System.out.println("Please make a selection: ");
        System.out.println("1 - Display All Vehicles");
        System.out.println("2 - Filter by Price");
        System.out.println("3 - Filter by Make and model");
        System.out.println("4 - Filter by Year");
        System.out.println("5 - Filter by Color");
        System.out.println("6 - Filter by Mileage");
        System.out.println("7 - Filter by Vehicle Type");
        System.out.println("8 - Add a Vehicle");
        System.out.println("9 - Remove a Vehicle");

        int selection = scanner.nextInt();
        scanner.nextLine();

        switch (selection) {
            case 1:
                processGetAllVehiclesRequest();
                break;
            case 2:
                processGetByPriceRequest();
                break;
            case 3:
                processGetByMakeModelRequest();
                break;
            case 4:
                processGetByYearRequest();
                break;
            case 5:
                processGetByColorRequest();
                break;
            case 6:
                processGetByMileageRequest();
                break;
            case 7:
                processGetByVehicleTypeRequest();
                break;
            case 8:
                processAddVehicleRequest();
                break;
//            case 9:
//                processRemoveVehicleRequest();
//                break;
//            case 10:
//                processGetVehiclesByVin();
//                break;

            default:
                System.out.println("Please make a valid selection.");
                break;
        }

    }

    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }

        }
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

//    public void processGetVehiclesByVin() {
//        System.out.println("Please enter a vin to search");
//        int vin = scanner.nextInt();
//
//        List<Vehicle> vehicleByVin = dealership.getV(vin);
//        displayVehicles(dealership.getVehiclesByVin(vin));
//
//    }


    public void processGetByPriceRequest() {
        System.out.println("Please enter a minimum price:");
        double min = scanner.nextDouble();
        System.out.println("Please enter a maximum price:");
        double max = scanner.nextDouble();
        displayVehicles(dealership.getVehiclesByPrice(min, max));

    }

    public void processGetByMakeModelRequest() {
        System.out.println("Please enter the Make of a Vehicle you would like to search:");
        String requestedMake = scanner.nextLine();
        System.out.println("Please enter the Model of a Vehicle you would like to search:");
        String requestedModel = scanner.nextLine();

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(requestedMake, requestedModel);
        displayVehicles(vehiclesByMakeModel);


    }

    public void processGetByYearRequest() {
        System.out.println("Please enter the Year of a Vehicle you would like to search:");
        int requestedYear = scanner.nextInt();
        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(requestedYear);
        displayVehicles(dealership.getVehiclesByYear(requestedYear));
    }

    public void processGetByColorRequest() {
        System.out.println("Please enter the Color of Vehicle you would like to search:");
        String requestedColor = scanner.nextLine();
        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(requestedColor);
        displayVehicles(dealership.getVehiclesByColor(requestedColor));
    }

    public void processGetByMileageRequest() {
        System.out.println("Please enter the minimum Mileage");
        int min = scanner.nextInt();
        System.out.println("Please enter the maximum Mileage:");
        int max = scanner.nextInt();
        List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(min, max);
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Please select a vehicle type");
        System.out.println("1 - Car");
        System.out.println("2 - SUV");
        System.out.println("3 - Truck");
        int selection = scanner.nextInt();
        List<Vehicle> vehiclesByType = dealership.getVehiclesByType(selection);
        displayVehicles(dealership.getVehiclesByType(selection));

    }

    public void processAddVehicleRequest() {

        System.out.println("Please enter the Vin Number");
        int vin = scanner.nextInt();
        System.out.println("Enter the Price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the Make ");
        String make = scanner.nextLine();
        System.out.println("Enter the Model");
        String model = scanner.nextLine();
        System.out.println("Enter the Year");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the color");
        String color = scanner.nextLine();
        System.out.println("Enter the Mileage");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Vehicle Type (Car, Truck, SUV)");
        String newVehicleType = scanner.nextLine();
        scanner.nextLine();

        System.out.println(year + " " + make + " " +  model + " added to the dealership");
        Vehicle vehicle = new Vehicle(vin, year, make, model, newVehicleType, color, mileage, price);

        dealership.addVehicle(vehicle);
        try (FileWriter fw = new FileWriter("newInventory.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(vin + "|" + year + "|" + make + "|" + model + "|" +
                    newVehicleType + "|" + color + "|" + mileage + "|" + price);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }




    }



//    public void processRemoveVehicleRequest() {
//        processGetAllVehiclesRequest();
//
//        System.out.println("Please enter the Vin Number of the vehicle to remove from inventory:");
//        int vinToRemove = scanner.nextInt();
//
//        Vehicle vehicleToRemove = null;
//        for (Vehicle vehicle : dealership.getAllVehicles()) {
//            if (vehicle.getVin() == vinToRemove) {
//                vehicleToRemove = vehicle;
//                break;
//            }
//        }
//
//        if (vehicleToRemove != null) {
//
//            dealership.getAllVehicles().remove(vehicleToRemove);
//            dealership.saveDealership();
//
//            System.out.println("Vehicle with VIN " + vinToRemove + " removed from the dealership.");
//        } else {
//            System.out.println("No vehicle found with VIN " + vinToRemove);
//        }
//    }
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

    }



}

