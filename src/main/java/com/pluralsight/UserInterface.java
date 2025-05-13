package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public void display() {
//        init(); // supposed to have right here
        System.out.println("Please make a selection: ");

//        System.out.println("1 - Display All Vehicles");
        System.out.println("2 - Filter by Price");
        System.out.println("3 - Filter by Make and model");
        System.out.println("4 - Filter by Year");
        System.out.println("5 - Display All Vehicles");
        System.out.println("6 - Filter by Mileage");
        System.out.println("7 - Filter by Vehicle Type");
        System.out.println("8 - Add a Vehicle");
        System.out.println("9 - Remove a Vehicle");

        int selection = scanner.nextInt();
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
                break;
            case 6:
                processGetByColorRequest();
                break;
//            case 7:
//                processGetByMileageRequest();
//                break;
//            case 8:
//                processGetByVehicleTypeRequest();
//                break;
//            case 9:
//                processAddVehicleRequest();
//                break;
//            case 10:
//                processRemoveVehicleRequest();
//                break;
            default:
                System.out.println("Please make a valid selection.");
                break;
        }


    }

    public void processGetByPriceRequest() {
        System.out.println("Please enter a minimum price:");
        double min = scanner.nextDouble();

        System.out.println("Please enter a maximum price:");
        double max = scanner.nextDouble();

        System.out.println("Should display all vehicles in a price range");
        List<Vehicle> inPriceRange = dealership.getVehiclesByPrice(min, max);

        if (inPriceRange.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Here are all of the results between $" + min + " and $" + max + ":");
            for (Vehicle vehicle : inPriceRange) {
                System.out.println(vehicle); // Make sure Vehicle has a good toString()
            }
        }
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Please enter the Make of a Vehicle you would like to search:");
        double requestedMake = scanner.nextDouble();
        System.out.println("Please enter the Model of a Vehicle you would like to search:");
        double requestedModel = scanner.nextDouble();

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByPrice(requestedMake, requestedModel);
        if (vehiclesByMakeModel.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Here are all of the " + requestedMake + " and " + requestedModel + "'s found in our system:");
            for (Vehicle vehicle : vehiclesByMakeModel) {
                System.out.println(vehicle);
                System.out.println("Match");
            }
        }

    }

    public void processGetByYearRequest() {
        System.out.println("Please enter the Year of a Vehicle you would like to search:");
        int requestedYear = scanner.nextInt();


        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(requestedYear);
        if (vehiclesByYear.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Here are all of the vehicles make in " + requestedYear + " found in our system:");
            for (Vehicle vehicle : vehiclesByYear) {
                System.out.println(vehicle);
                System.out.println("Match");
            }
        }

    }

    public void processGetAllVehiclesRequest() {

    }

    public void processGetByColorRequest() {
        System.out.println("Please enter the Color of Vehicle you would like to search:");
        String requestedColor = scanner.nextLine();

        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(requestedColor);
        if (vehiclesByColor.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Here are all of the  " + requestedColor + " vehicles found in our system:");
            for (Vehicle vehicle : vehiclesByColor) {
                System.out.println(vehicle);
                System.out.println("Match");
            }
        }
    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processAddVehicleRequest() {
    }

    public void processRemoveVehicleRequest() {

    }


    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

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





}

