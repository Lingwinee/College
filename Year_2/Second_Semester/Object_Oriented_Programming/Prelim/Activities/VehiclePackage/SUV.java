/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiclePackage;

/**
 *
 * @author joopa04
 * SUV extends Car.
 * Adds off-road capabilities and cargo space.
 * Less fuel efficient and accelerates slower.
 */
public class SUV extends Car {
    private boolean is4WD;
    private double groundClearanceCM;
    private double cargoSpaceLiters; // Additional space beyond trunk

    public SUV() {
        super();
    }

    public SUV(boolean is4WD, double groundClearanceCM, double cargoSpaceLiters, int numDoors, 
               String transmission, double trunkCapacityLitters, double kmPerLiter, String vehicleID, 
               String brand, String model, int year, String color, String fuelType, double fuelLevel, 
               double speed, boolean isRunning) {
        
        super(numDoors, transmission, trunkCapacityLitters, kmPerLiter, vehicleID, brand, model, year, color, fuelType, fuelLevel, speed, isRunning);
        this.is4WD = is4WD;
        this.groundClearanceCM = groundClearanceCM;
        this.cargoSpaceLiters = cargoSpaceLiters;
    }

    public void toggle4WD() {
        if (is4WD) {
            System.out.println("Toggling 4WD system.");
        } else {
            System.out.println("This SUV does not have 4WD.");
        }
    }

    @Override
    public void accelerate(double amount) {
        // SUV is heavier, accelerates at 80% efficiency
        double effectiveAmount = amount * 0.8;
        System.out.print("[SUV Heavy Acceleration] ");
        super.accelerate(effectiveAmount);
    }

    @Override
    public double calculateTripCost(double km, double fuelPricePerLiter) {
        // SUV consumes more fuel. We assume the base kmPerLiter is accurate,
        // but if 4WD is engaged (conceptually), it might cost more.
        // For this implementation, we rely on the standard formula using the SUV's specific kmPerLiter.
        return super.calculateTripCost(km, fuelPricePerLiter);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("====== SUV Information ======");
        System.out.println("4WD:          " + this.is4WD);
        System.out.println("Ground Clr(cm):" + this.groundClearanceCM);
        System.out.println("Cargo Space(L):" + this.cargoSpaceLiters);
    }
    
    // Getters and Setters
    public boolean isIs4WD() { return is4WD; }
    public void setIs4WD(boolean is4WD) { this.is4WD = is4WD; }
    public double getGroundClearanceCM() { return groundClearanceCM; }
    public void setGroundClearanceCM(double groundClearanceCM) { this.groundClearanceCM = groundClearanceCM; }
    public double getCargoSpaceLiters() { return cargoSpaceLiters; }
    public void setCargoSpaceLiters(double cargoSpaceLiters) { this.cargoSpaceLiters = cargoSpaceLiters; }
}