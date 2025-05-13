package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    public void display(){
        Dealership dealership;
        init();
 //what???
        Scanner scanner = new Scanner("inventory.csv");
        System.out.println("Calling init");
         init();

        System.out.println("Please make a selection: ");
        int selection = scanner.nextInt();

        System.out.println("1 - Display All Vehicles");
        System.out.println("2 - Filter by Price");
        System.out.println("3 - Filter by Make and model");
        System.out.println("4 - Filter by Year");
        System.out.println("5 - Filter by Mileage");
        System.out.println("6 - Filter by Vehicle Type");
        System.out.println("7 - Add a Vehicle");
        System.out.println("8 - Remove a Vehicle");

        switch (selection) {
            case 1:
                display();
                System.out.println("all");
                break;
            case 2:
                processGetByPriceRequest();
                break;
//            case 3:
//                processGetByMakeModelRequest();
//                break;
//            case 4:
//                processGetByYearRequest();
//                break;
//            case 5:
//                processGetByColorRequest();
//                break;
//            case 6:
//                processGetByMileageRequest();
//                break;
//            case 7:
//                processGetByVehicleTypeRequest();
//                break;
//            case 8:
//                processAddVehicleRequest();
//                break;
//            case 9:
//                processRemoveVehicleRequest();
//                break;
            default:
                System.out.println("Please make a valid selection.");
                break;
        }



    }
    public void processGetByPriceRequest(){
        System.out.println("Price");
    }
    public void processGetByMakeModelRequest(){
        System.out.println("Make / Model");
    }
    public void processGetByYearRequest(){

    }
    public void processGetByColorRequest(){

    }
    public void processGetByMileageRequest(){

    }public void processGetByVehicleTypeRequest(){

    }
    public void processGetAllVehiclesRequest(){
        System.out.println("Complete");
    }
    public void processAddVehicleRequest(){
    }
    public void processRemoveVehicleRequest(){

    }

    private void init(){
        System.out.println("Complete");
    }
    public void displayVehicles(){
        System.out.println("Complete");
    }
}
