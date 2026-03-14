/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FleetPackage;

/**
 *
 * @author joopa04
 */

public class Bus extends Vehicle implements PassengerCarrier, CargoCarrier, Insurable, Maintainable {

    private static final double MAINTENANCE_THRESHOLD = 8000.0;
    private static final double BASE_VALUE            = 3_000_000.0;

    // ── Attributes ────────────────────────────────────────────────────────────
    private int     passengerCapacity;
    private int     currentPassengers;
    private boolean hasAircon;
    private String  routeName;
    private double  maxCargoKg;
    private double  currentCargoKg;
    private double  maintenanceKmCounter;

    // ── Constructor ───────────────────────────────────────────────────────────
    public Bus(String vehicleId, String brand, String model, int year,
               String color, FuelType fuelType, double fuelLevel,
               int passengerCapacity, boolean hasAircon,
               String routeName, double maxCargoKg) {
        super(vehicleId, brand, model, year, color, fuelType, fuelLevel);
        this.passengerCapacity    = passengerCapacity;
        this.currentPassengers    = 0;
        this.hasAircon            = hasAircon;
        this.routeName            = routeName;
        this.maxCargoKg           = maxCargoKg;
        this.currentCargoKg       = 0.0;
        this.maintenanceKmCounter = 0.0;
    }

    // ── Vehicle Abstracts ─────────────────────────────────────────────────────

    @Override
    public double getKmPerLiter() {
        // Worst base efficiency; further reduced by aircon
        double base = 6.0;
        if (hasAircon) base -= 1.0;
        return base;
    }

    @Override
    public void accelerate(double amount) {
        if (!isRunning) {
            System.out.println("[" + vehicleId + "] Cannot accelerate: engine is off.");
            return;
        }
        // Passengers slow the bus down
        double loadFactor = 1.0 - (currentPassengers / (double) passengerCapacity) * 0.30;
        double effective  = amount * loadFactor;
        speed += effective;
        System.out.printf("[%s] Speed is now %.1f km/h (load factor: %.2f).%n",
                          vehicleId, speed, loadFactor);
    }

    @Override
    public double calculateTripCost(double km, double fuelPricePerLiter) {
        return (km / getKmPerLiter()) * fuelPricePerLiter;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========================================");
        System.out.println("  [ BUS ]");
        printBaseInfo();
        System.out.println("  Route      : " + routeName);
        System.out.println("  Passengers : " + currentPassengers + " / " + passengerCapacity);
        System.out.println("  Aircon     : " + (hasAircon ? "Yes" : "No"));
        System.out.printf ("  Cargo      : %.1f / %.1f kg%n", currentCargoKg, maxCargoKg);
        System.out.printf ("  Km/Liter   : %.1f%n", getKmPerLiter());
    }

    // ── PassengerCarrier ──────────────────────────────────────────────────────

    @Override public int getPassengerCapacity()  { return passengerCapacity; }
    @Override public int getCurrentPassengers()  { return currentPassengers; }

    @Override
    public void board(int count) {
        if (currentPassengers + count > passengerCapacity) {
            System.out.printf("[%s] Cannot board %d passenger(s) — capacity exceeded.%n",
                              vehicleId, count);
            return;
        }
        currentPassengers += count;
        System.out.printf("[%s] %d passenger(s) boarded. Total: %d.%n",
                          vehicleId, count, currentPassengers);
    }

    @Override
    public void alight(int count) {
        currentPassengers = Math.max(0, currentPassengers - count);
        System.out.printf("[%s] %d passenger(s) alighted. Remaining: %d.%n",
                          vehicleId, count, currentPassengers);
    }

    // ── CargoCarrier ──────────────────────────────────────────────────────────

    @Override public double getMaxCargoKg()     { return maxCargoKg; }
    @Override public double getCurrentCargoKg() { return currentCargoKg; }

    @Override
    public void loadCargo(double kg) {
        if (currentCargoKg + kg > maxCargoKg) {
            System.out.printf("[%s] Cannot load %.1f kg — exceeds max cargo of %.1f kg.%n",
                              vehicleId, kg, maxCargoKg);
            return;
        }
        currentCargoKg += kg;
        System.out.printf("[%s] Loaded %.1f kg. Total: %.1f kg.%n", vehicleId, kg, currentCargoKg);
    }

    @Override
    public void unloadCargo(double kg) {
        currentCargoKg = Math.max(0.0, currentCargoKg - kg);
        System.out.printf("[%s] Unloaded %.1f kg. Remaining: %.1f kg.%n", vehicleId, kg, currentCargoKg);
    }

    // ── Maintainable ─────────────────────────────────────────────────────────

    @Override
    public boolean needsMaintenance() {
        return maintenanceKmCounter >= MAINTENANCE_THRESHOLD;
    }

    @Override
    public void performMaintenance() {
        maintenanceKmCounter = 0.0;
        System.out.println("[" + vehicleId + "] Bus maintenance performed. Counter reset.");
    }

    public void drive(double km) {
        maintenanceKmCounter += km;
        odometerKm           += km;
    }

    // ── Insurable ─────────────────────────────────────────────────────────────

    @Override
    public double getInsuranceRate() {
        return 0.07;   // 7% — highest rate
    }

    @Override
    public double calculateAnnualInsurance() {
        double depreciation = Math.pow(0.85, getAge());
        return BASE_VALUE * depreciation * getInsuranceRate();
    }
}
