/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiclePackage;

/**
 *
 * @author joopa04
 * Sedan extends Car.
 * Adds luxury features like seat material and Eco Mode.
 * Typically has better fuel efficiency.
 */
public class Sedan extends Car {
    private String seatMaterial; // Fabric, Leather
    private boolean hasEcoMode;

    public Sedan() {
        super();
    }

    public Sedan(String seatMaterial, boolean hasEcoMode, int numDoors, String transmission, 
                 double trunkCapacityLitters, double kmPerLiter, String vehicleID, String brand, 
                 String model, int year, String color, String fuelType, double fuelLevel, 
                 double speed, boolean isRunning) {
        
        super(numDoors, transmission, trunkCapacityLitters, kmPerLiter, vehicleID, brand, model, year, color, fuelType, fuelLevel, speed, isRunning);
        this.seatMaterial = seatMaterial;
        this.hasEcoMode = hasEcoMode;
    }

    public void toggleEcoMode() {
        if (hasEcoMode) {
            System.out.println("Toggling Eco Mode...");
            // Logic to actually change internal state could go here if we tracked current mode
            System.out.println("Eco Mode toggled.");
        } else {
            System.out.println("This sedan does not have Eco Mode.");
        }
    }

    /**
     * Override calculateTripCost.
     * Sedan is generally more efficient, so we simulate a slight efficiency boost 
     * or simply rely on the high kmPerLiter passed in the constructor.
     * Here, we assume the base calculation holds, but the user should have initialized
     * the Sedan with a higher kmPerLiter value.
     */
    @Override
    public double calculateTripCost(double km, double fuelPricePerLiter) {
        // We can check if EcoMode reduces cost further, for example:
        double cost = super.calculateTripCost(km, fuelPricePerLiter);
        if (hasEcoMode) {
            // Assume 10% savings if equipped with EcoMode
            return cost * 0.9;
        }
        return cost;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("====== Sedan Information ======");
        System.out.println("Seat Material:" + this.seatMaterial);
        System.out.println("Has Eco Mode: " + this.hasEcoMode);
    }
    
    // Getters and Setters
    public String getSeatMaterial() { return seatMaterial; }
    public void setSeatMaterial(String seatMaterial) { this.seatMaterial = seatMaterial; }
    public boolean isHasEcoMode() { return hasEcoMode; }
    public void setHasEcoMode(boolean hasEcoMode) { this.hasEcoMode = hasEcoMode; }
}