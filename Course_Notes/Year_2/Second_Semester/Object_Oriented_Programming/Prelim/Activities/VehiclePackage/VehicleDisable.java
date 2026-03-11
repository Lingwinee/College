/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiclePackage;

/**
 *
 * @author joopa04
 * Base class for all vehicles.
 * Manages basic movement, fuel, and state.
 */
public class VehicleDisable {
    private String vehicleID;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String fuelType; // Gas, Diesel, Electric
    private double fuelLevel; // 0 - 100
    private double speed;
    private boolean isRunning;

    // Default Constructor
    public VehicleDisable() {
        this.vehicleID = "NO_ID_GIVEN";
        this.isRunning = false;
        this.speed = 0;
        this.fuelLevel = 0;
    }

    // Parameterized Constructor
    public VehicleDisable(String vehicleID, String brand, String model, int year, String color, String fuelType, double fuelLevel, double speed, boolean isRunning) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.fuelType = fuelType;
        this.fuelLevel = fuelLevel;
        this.speed = speed;
        this.isRunning = isRunning;
    }

    public void startEngine() {
        if (isRunning) {
            System.out.println("Engine is already running.");
            return;
        }

        if (fuelLevel > 0) {
            isRunning = true;
            System.out.println("Engine started.");
        } else {
            System.out.println("Low fuel, cannot start engine.");
        }
    }

    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            speed = 0;
            System.out.println("Engine stopped.");
        } else {
            System.out.println("Vehicle is not running.");
        }
    }

    public void accelerate(double amount) {
        if (!isRunning) {
            System.out.println("Cannot accelerate, vehicle not running.");
            return;
        }

        if (amount > 0) {
            this.speed += amount;
            System.out.println("Accelerating. Speed is now: " + this.speed);
        }
    }

    public void brake(double amount) {
        if (speed > 0) {
            this.speed -= amount;
            if (speed < 0) this.speed = 0;
            System.out.println("Braking. Speed is now: " + this.speed);
        } else {
            System.out.println("Vehicle is already stopped.");
        }
    }

    public void refuel(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid fuel amount.");
            return;
        }
        
        if (this.fuelLevel + amount > 100) {
            this.fuelLevel = 100;
            System.out.println("Tank full (100%).");
        } else {
            this.fuelLevel += amount;
            System.out.println("Refueled. Current level: " + this.fuelLevel + "%");
        }
    }

    public void displayInfo() {
        System.out.println("\n=== Vehicle Information ===");
        System.out.println("ID:           " + this.vehicleID);
        System.out.println("Brand:        " + this.brand);
        System.out.println("Model:        " + this.model);
        System.out.println("Year:         " + this.year);
        System.out.println("Color:        " + this.color);
        System.out.println("Fuel Type:    " + this.fuelType);
        System.out.println("Fuel Level:   " + this.fuelLevel);
        System.out.println("Speed:        " + this.speed);
        System.out.println("Is Running:   " + this.isRunning);
    }

    /**
     * Subclasses can optionally override this.
     * Default assumption: 10 km per liter.
     */
    public double getKmPerLiter() {
        return 10.0;
    }

    public double calculateTripCost(double km, double fuelPricePerLiter) {
        double kmPerLiter = getKmPerLiter();
        if (kmPerLiter <= 0) {
            System.out.println("Fuel efficiency not defined correctly.");
            return 0;
        }
        double litersNeeded = km / kmPerLiter;
        return litersNeeded * fuelPricePerLiter;
    }

    // ========================= Setters =========================
    public void setVehicleID(String vehicleID) { this.vehicleID = vehicleID; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setColor(String color) { this.color = color; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    public void setFuelLevel(double fuelLevel) { this.fuelLevel = fuelLevel; }
    public void setSpeed(double speed) { this.speed = speed; }
    public void setIsRunning(boolean isRunning) { this.isRunning = isRunning; }

    // ========================= Getters =========================
    public String getVehicleID() { return vehicleID; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public String getFuelType() { return fuelType; }
    public double getFuelLevel() { return fuelLevel; }
    public double getSpeed() { return speed; }
    public boolean isIsRunning() { return isRunning; }
}