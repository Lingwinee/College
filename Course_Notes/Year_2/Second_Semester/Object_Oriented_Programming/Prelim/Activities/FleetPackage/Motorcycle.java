/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FleetPackage;

/**
 *
 * @author joopa04
 */
public class Motorcycle extends Vehicle implements Maintainable {

    private static final double MAINTENANCE_THRESHOLD = 3000.0;

    // ── Attributes ────────────────────────────────────────────────────────────
    private int     engineCC;
    private boolean hasSidecar;
    private int     helmetCount;
    private double  maintenanceKmCounter;

    // ── Constructor ───────────────────────────────────────────────────────────
    public Motorcycle(String vehicleId, String brand, String model, int year,
                      String color, FuelType fuelType, double fuelLevel,
                      int engineCC, boolean hasSidecar, int helmetCount) {
        super(vehicleId, brand, model, year, color, fuelType, fuelLevel);
        this.engineCC             = engineCC;
        this.hasSidecar           = hasSidecar;
        this.helmetCount          = helmetCount;
        this.maintenanceKmCounter = 0.0;
    }

    // ── Extra Method ──────────────────────────────────────────────────────────

    public void popWheelie() {
        if (speed >= 20.0 && !hasSidecar) {
            System.out.println("[" + vehicleId + "] Wheelie! 🏍️");
        } else if (hasSidecar) {
            System.out.println("[" + vehicleId + "] Cannot pop a wheelie: sidecar is attached.");
        } else {
            System.out.printf("[%s] Cannot pop a wheelie: speed (%.1f km/h) must be >= 20 km/h.%n",
                              vehicleId, speed);
        }
    }

    // ── Vehicle Abstracts ─────────────────────────────────────────────────────

    @Override
    public double getKmPerLiter() {
        // Higher CC = slightly less efficient
        if (engineCC <= 150)      return 40.0;
        else if (engineCC <= 400) return 28.0;
        else                      return 18.0;
    }

    @Override
    public double calculateTripCost(double km, double fuelPricePerLiter) {
        return (km / getKmPerLiter()) * fuelPricePerLiter;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========================================");
        System.out.println("  [ MOTORCYCLE ]");
        printBaseInfo();
        System.out.println("  Engine CC  : " + engineCC + " cc");
        System.out.println("  Sidecar    : " + (hasSidecar ? "Yes" : "No"));
        System.out.println("  Helmets    : " + helmetCount);
        System.out.printf ("  Km/Liter   : %.1f%n", getKmPerLiter());
    }

    // ── Maintainable ─────────────────────────────────────────────────────────

    @Override
    public boolean needsMaintenance() {
        return maintenanceKmCounter >= MAINTENANCE_THRESHOLD;
    }

    @Override
    public void performMaintenance() {
        maintenanceKmCounter = 0.0;
        System.out.println("[" + vehicleId + "] Motorcycle maintenance performed. Counter reset.");
    }

    public void drive(double km) {
        maintenanceKmCounter += km;
        odometerKm           += km;
    }
}
