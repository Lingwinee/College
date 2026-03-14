/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiclePackage;

/**
 *
 * @author joopa04
 * Car extends Vehicle.
 * Adds doors, transmission, and trunk logic.
 */
public class Car extends VehicleDisable {
    private int numDoors;
    private String transmission; // Automatic, Semi-automatic, Manual
    private double trunkCapacityLitters;
    private double kmPerLiter;

    public Car() {
        super();
    }

    public Car(int numDoors, String transmission, double trunkCapacityLitters, double kmPerLiter, 
               String vehicleID, String brand, String model, int year, String color, String fuelType, 
               double fuelLevel, double speed, boolean isRunning) {
        super(vehicleID, brand, model, year, color, fuelType, fuelLevel, speed, isRunning);
        this.numDoors = numDoors;
        this.transmission = transmission;
        this.trunkCapacityLitters = trunkCapacityLitters;
        this.kmPerLiter = kmPerLiter;
    }

    public void openTrunk() {
        System.out.println("Trunk opened. Capacity: " + this.trunkCapacityLitters + " Liters.");
    }

    public String getVehicleCategory() {
        return "Car";
    }

    @Override
    public double getKmPerLiter() {
        return this.kmPerLiter;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("====== Car Information ======");
        System.out.println("Category:     " + getVehicleCategory());
        System.out.println("Door count:   " + this.numDoors);
        System.out.println("Transmission: " + this.transmission);
        System.out.println("Trunk Cap(L): " + this.trunkCapacityLitters);
        System.out.println("KM Per L:     " + this.kmPerLiter);
    }
    
    // Setters
    public void setNumDoors(int numDoors) { this.numDoors = numDoors; }
    public void setTransmission(String transmission) { this.transmission = transmission; }
    public void setTrunkCapacityLitters(double trunkCapacityLitters) { this.trunkCapacityLitters = trunkCapacityLitters; }
    public void setKmPerLiter(double kmPerLiter) { this.kmPerLiter = kmPerLiter; }

    // Getters
    public int getNumDoors() { return numDoors; }
    public String getTransmission() { return transmission; }
    public double getTrunkCapacityLitters() { return trunkCapacityLitters; }
}
