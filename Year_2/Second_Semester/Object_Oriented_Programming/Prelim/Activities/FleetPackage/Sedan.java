/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FleetPackage;

/**
 *
 * @author joopa04
 */
public class Sedan extends Car implements Insurable, Maintainable {

    private static final double MAINTENANCE_THRESHOLD = 5000.0;
    private static final double BASE_VALUE            = 800_000.0;

    // ── Attributes ────────────────────────────────────────────────────────────
    private String  seatMaterial;
    private boolean hasEcoMode;
    private boolean ecoModeOn;
    private double  maintenanceKmCounter;

    // ── Constructor ───────────────────────────────────────────────────────────
    public Sedan(String vehicleId, String brand, String model, int year,
                 String color, FuelType fuelType, double fuelLevel,
                 int numDoors, String transmission, double trunkCapacityLiters,
                 String seatMaterial, boolean hasEcoMode) {
        super(vehicleId, brand, model, year, color, fuelType, fuelLevel,
              numDoors, transmission, trunkCapacityLiters);
        this.seatMaterial         = seatMaterial;
        this.hasEcoMode           = hasEcoMode;
        this.ecoModeOn            = false;
        this.maintenanceKmCounter = 0.0;
    }

    // ── Extra Method ──────────────────────────────────────────────────────────

    public void toggleEcoMode() {
        if (!hasEcoMode) {
            System.out.println("[" + vehicleId + "] This sedan does not have Eco Mode.");
            return;
        }
        ecoModeOn = !ecoModeOn;
        System.out.println("[" + vehicleId + "] Eco Mode turned " + (ecoModeOn ? "ON" : "OFF") + ".");
    }

    // ── Vehicle Abstracts ─────────────────────────────────────────────────────

    @Override
    public double getKmPerLiter() {
        return ecoModeOn ? 18.0 : 15.0;   // Better efficiency than SUV
    }

    @Override
    public double calculateTripCost(double km, double fuelPricePerLiter) {
        return (km / getKmPerLiter()) * fuelPricePerLiter;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========================================");
        System.out.println("  [ SEDAN ]");
        super.displayInfo();    // Car.displayInfo() which calls printBaseInfo()
        System.out.println("  Seat Mat.  : " + seatMaterial);
        System.out.println("  Eco Mode   : " + (ecoModeOn ? "ON" : "OFF"));
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
        System.out.println("[" + vehicleId + "] Sedan maintenance performed. Counter reset.");
    }

    // Simulate driving to trigger maintenance counter
    public void drive(double km) {
        maintenanceKmCounter += km;
        odometerKm           += km;
    }

    // ── Insurable ─────────────────────────────────────────────────────────────

    @Override
    public double getInsuranceRate() {
        return 0.03;   // 3% — cheaper than SUV
    }

    @Override
    public double calculateAnnualInsurance() {
        double depreciation = Math.pow(0.90, getAge());
        return BASE_VALUE * depreciation * getInsuranceRate();
    }
}
