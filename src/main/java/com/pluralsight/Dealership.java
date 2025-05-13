package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    //getVehicleByMakeModel etc from java class


    public Dealership(String name, String address, String phone) {
        this.name = "";
        this.address = "";
        this.phone = "";
        inventory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<Vehicle> getAllVehicles(){
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            System.out.println(vehicle);
        }
        return allVehicles;
    }
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> inPriceRange = new ArrayList<>();
        for (Vehicle vehicle : inventory){
          if(vehicle.getPrice() <= max && vehicle.getPrice() >= min){
              inPriceRange.add(vehicle);
          }
        } return inPriceRange;
    }
    public List<Vehicle> getVehiclesByMakeModel(String requestedMake, String requestedModel){
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(requestedMake) && vehicle.getModel().equalsIgnoreCase(requestedModel)){
                vehiclesByMakeModel.add(vehicle);
            }
        } return vehiclesByMakeModel;
    }
    public List<Vehicle> getVehiclesByYear(int requestedYear){
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if(vehicle.getYear() == (requestedYear)){
                vehiclesByYear.add(vehicle);
            }
        } return vehiclesByYear;
    }
    public List<Vehicle> getVehiclesByColor(String requestedColor){
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if(requestedColor.equalsIgnoreCase(vehicle.getColor())){
                  vehiclesByColor.add(vehicle);
            }
        } return vehiclesByColor;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMileage(min) >= min && vehicle.getMileage(max) <= max) {
                vehiclesByMileage.add(vehicle);
            }
        }
        return vehiclesByMileage;
    }
    public List<Vehicle> getVehiclesByType(int selection){
        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            switch (selection) {
                case 1: // Car
                    if (vehicle.getVehicleType().equalsIgnoreCase("car")) {
                        vehiclesByType.add(vehicle);
                    }
                    break;
                case 2: // Truck
                    if (vehicle.getVehicleType().equalsIgnoreCase("truck")) {
                        vehiclesByType.add(vehicle);
                    }
                    break;
                case 3: // SUV
                    if (vehicle.getVehicleType().equalsIgnoreCase("SUV")) {
                        vehiclesByType.add(vehicle);
                    }
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;


            }
        }
        return vehiclesByType;
    }




public saveDealership(){

}
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }



}
