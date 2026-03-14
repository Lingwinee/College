/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FleetPackage;

/**
 *
 * @author joopa04
 */
public abstract class Car extends Vehicle {

    // ── Attributes ────────────────────────────────────────────────────────────
    protected int    numDoors;
    protected String transmission;          // "Manual" or "Automatic"
    protected double trunkCapacityLiters;

    // ── Constructor ───────────────────────────────────────────────────────────
    public Car(String vehicleId, String brand, String model, int year,
               String color, FuelType fuelType, double fuelLevel,
               int numDoors, String transmission, double trunkCapacityLiters) {
        super(vehicleId, brand, model, year, color, fuelType, fuelLevel);
        this.numDoors            = numDoors;
        this.transmission        = transmission;
        this.trunkCapacityLiters = trunkCapacityLiters;
    }

    // ── Concrete Methods ──────────────────────────────────────────────────────

    public void openTrunk() {
        System.out.println("[" + vehicleId + "] Trunk opened.");
    }

    // ── Override displayInfo() ────────────────────────────────────────────────
    // Subclasses (Sedan, SUV) should call super.displayInfo() then add more.
    @Override
    public void displayInfo() {
        printBaseInfo();
        System.out.println("  Doors      : " + numDoors);
        System.out.println("  Trans.     : " + transmission);
        System.out.printf ("  Trunk      : %.1f L%n", trunkCapacityLiters);
    }
}
