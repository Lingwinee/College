/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiclePackage;

/**
 *
 * Bus extends Vehicle.
 * Manages passengers and slow acceleration.
 */
public class Bus extends VehicleDisable {
    private int passengerCapacity;
    private int currentPassengers;
    private boolean hasAircon;
    private String routeName;

    public Bus() {
        super();
    }

    public Bus(int passengerCapacity, int currentPassengers, boolean hasAircon, String routeName, 
               String vehicleID, String brand, String model, int year, String color, String fuelType, 
               double fuelLevel, double speed, boolean isRunning) {
        
        super(vehicleID, brand, model, year, color, fuelType, fuelLevel, speed, isRunning);
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = currentPassengers;
        this.hasAircon = hasAircon;
        this.routeName = routeName;
    }

    public void boardPassengers(int count) {
        if (count <= 0) return;
        
        if (currentPassengers + count <= passengerCapacity) {
            currentPassengers += count;
            System.out.println(count + " passengers boarded. Total: " + currentPassengers);
        } else {
            System.out.println("Cannot board " + count + ". Only " + (passengerCapacity - currentPassengers) + " seats left.");
        }
    }

    public void dropOffPassengers(int count) {
        if (count <= 0) return;

        if (currentPassengers - count >= 0) {
            currentPassengers -= count;
            System.out.println(count + " passengers dropped off. Total: " + currentPassengers);
        } else {
            System.out.println("Cannot drop off " + count + ". Only " + currentPassengers + " on board.");
        }
    }

    @Override
    public void accelerate(double amount) {
        double efficiency = 0.6; // Base bus is slow
        
        // Even slower if crowded
        if (currentPassengers > passengerCapacity / 2) {
            efficiency = 0.4;
        }

        double effectiveAmount = amount * efficiency;
        System.out.print("[Bus Acceleration] ");
        super.accelerate(effectiveAmount);
    }

    @Override
    public double getKmPerLiter() {
        // High fuel usage
        double baseEfficiency = 5.0; 
        if (hasAircon) baseEfficiency -= 1.0; // Aircon uses fuel
        return baseEfficiency;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("====== Bus Information ======");
        System.out.println("Route:        " + this.routeName);
        System.out.println("Capacity:     " + this.passengerCapacity);
        System.out.println("Passengers:   " + this.currentPassengers);
        System.out.println("Has Aircon:   " + this.hasAircon);
    }
    
    // Getters and Setters
    public int getPassengerCapacity() { return passengerCapacity; }
    public void setPassengerCapacity(int passengerCapacity) { this.passengerCapacity = passengerCapacity; }
    public int getCurrentPassengers() { return currentPassengers; }
    public void setCurrentPassengers(int currentPassengers) { this.currentPassengers = currentPassengers; }
    public boolean isHasAircon() { return hasAircon; }
    public void setHasAircon(boolean hasAircon) { this.hasAircon = hasAircon; }
    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }
}