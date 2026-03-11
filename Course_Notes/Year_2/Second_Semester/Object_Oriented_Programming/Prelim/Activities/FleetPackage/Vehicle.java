/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FleetPackage;

/**
 *
 * @author joopa04
 */
import java.time.Year;

public abstract class Vehicle {

    // ── Attributes ────────────────────────────────────────────────────────────
    protected String   vehicleId;
    protected String   brand;
    protected String   model;
    protected int      year;
    protected String   color;
    protected FuelType fuelType;
    protected double   fuelLevel;   // 0–100
    protected double   speed;
    protected boolean  isRunning;
    protected double   odometerKm;

    // ── Constructor ───────────────────────────────────────────────────────────
    public Vehicle(String vehicleId, String brand, String model, int year,
                   String color, FuelType fuelType, double fuelLevel) {
        this.vehicleId  = vehicleId;
        this.brand      = brand;
        this.model      = model;
        this.year       = year;
        this.color      = color;
        this.fuelType   = fuelType;
        this.fuelLevel  = fuelLevel;
        this.speed      = 0.0;
        this.isRunning  = false;
        this.odometerKm = 0.0;
    }

    // ── Concrete Methods ──────────────────────────────────────────────────────

    public void startEngine() {
        if (fuelLevel <= 0) {
            System.out.println("[" + vehicleId + "] Cannot start: fuel is empty.");
            return;
        }
        isRunning = true;
        System.out.println("[" + vehicleId + "] Engine started.");
    }

    public void stopEngine() {
        speed     = 0.0;
        isRunning = false;
        System.out.println("[" + vehicleId + "] Engine stopped.");
    }

    public void accelerate(double amount) {
        if (!isRunning) {
            System.out.println("[" + vehicleId + "] Cannot accelerate: engine is off.");
            return;
        }
        speed += amount;
        System.out.printf("[%s] Speed is now %.1f km/h.%n", vehicleId, speed);
    }

    public void brake(double amount) {
        speed = Math.max(0.0, speed - amount);
        System.out.printf("[%s] Speed is now %.1f km/h.%n", vehicleId, speed);
    }

    public void refuel(double amount) {
        fuelLevel = Math.min(100.0, fuelLevel + amount);
        System.out.printf("[%s] Refueled. Fuel level: %.1f%%.%n", vehicleId, fuelLevel);
    }

    public boolean needsRefuel() {
        return fuelLevel < 15.0;
    }

    public int getAge() {
        return Year.now().getValue() - year;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public String getVehicleId() { return vehicleId; }
    public double getSpeed()     { return speed; }

    // ── Helper for subclass displayInfo() ────────────────────────────────────
    protected void printBaseInfo() {
        System.out.println("  ID         : " + vehicleId);
        System.out.println("  Brand      : " + brand + " " + model + " (" + year + ")");
        System.out.println("  Color      : " + color);
        System.out.println("  Fuel Type  : " + fuelType);
        System.out.printf ("  Fuel Level : %.1f%%%n", fuelLevel);
        System.out.printf ("  Speed      : %.1f km/h%n", speed);
        System.out.printf ("  Odometer   : %.1f km%n", odometerKm);
        System.out.println("  Age        : " + getAge() + " year(s)");
    }

    // ── Abstract Methods ──────────────────────────────────────────────────────

    public abstract double getKmPerLiter();
    public abstract double calculateTripCost(double km, double fuelPricePerLiter);
    public abstract void   displayInfo();
}