/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FleetPackage;

/**
 *
 * @author joopa04
 */
public class SUV extends Car implements CargoCarrier, Insurable, Maintainable {

    private static final double MAINTENANCE_THRESHOLD = 5000.0;
    private static final double BASE_VALUE            = 1_500_000.0;

    // ── Attributes ────────────────────────────────────────────────────────────
    private boolean is4WD;
    private double  groundClearanceCM;
    private double  maxCargoKg;
    private double  currentCargoKg;
    private double  maintenanceKmCounter;

    // ── Constructor ───────────────────────────────────────────────────────────
    public SUV(String vehicleId, String brand, String model, int year,
               String color, FuelType fuelType, double fuelLevel,
               int numDoors, String transmission, double trunkCapacityLiters,
               boolean is4WD, double groundClearanceCM, double maxCargoKg) {
        super(vehicleId, brand, model, year, color, fuelType, fuelLevel,
              numDoors, transmission, trunkCapacityLiters);
        this.is4WD                = is4WD;
        this.groundClearanceCM    = groundClearanceCM;
        this.maxCargoKg           = maxCargoKg;
        this.currentCargoKg       = 0.0;
        this.maintenanceKmCounter = 0.0;
    }

    // ── Extra Method ──────────────────────────────────────────────────────────

    public void toggle4WD() {
        is4WD = !is4WD;
        System.out.println("[" + vehicleId + "] 4WD turned " + (is4WD ? "ON" : "OFF") + ".");
    }

    // ── Vehicle Abstracts ─────────────────────────────────────────────────────

    @Override
    public double getKmPerLiter() {
        return 10.0;   // Less efficient than Sedan
    }

    @Override
    public void accelerate(double amount) {
        // SUV has slower acceleration (80% effect)
        super.accelerate(amount * 0.80);
    }

    @Override
    public double calculateTripCost(double km, double fuelPricePerLiter) {
        return (km / getKmPerLiter()) * fuelPricePerLiter;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========================================");
        System.out.println("  [ SUV ]");
        super.displayInfo();
        System.out.println("  4WD        : " + (is4WD ? "Yes" : "No"));
        System.out.printf ("  Clearance  : %.1f cm%n", groundClearanceCM);
        System.out.printf ("  Cargo      : %.1f / %.1f kg%n", currentCargoKg, maxCargoKg);
        System.out.printf ("  Km/Liter   : %.1f%n", getKmPerLiter());
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
        System.out.println("[" + vehicleId + "] SUV maintenance performed. Counter reset.");
    }

    public void drive(double km) {
        maintenanceKmCounter += km;
        odometerKm           += km;
    }

    // ── Insurable ─────────────────────────────────────────────────────────────

    @Override
    public double getInsuranceRate() {
        return 0.05;   // 5% — higher than Sedan
    }

    @Override
    public double calculateAnnualInsurance() {
        double depreciation = Math.pow(0.90, getAge());
        return BASE_VALUE * depreciation * getInsuranceRate();
    }
}
