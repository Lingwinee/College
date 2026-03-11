/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiclePackage;

/**
 *
 * Motorcycle extends Vehicle.
 * Specific features like sidecar and wheelies.
 */
public class Motorcycle extends VehicleDisable {
    private int engineCC;
    private boolean hasSidecar;
    private int helmetCount;

    public Motorcycle() {
        super();
    }

    public Motorcycle(int engineCC, boolean hasSidecar, int helmetCount, String vehicleID, 
                      String brand, String model, int year, String color, String fuelType, 
                      double fuelLevel, double speed, boolean isRunning) {
        
        super(vehicleID, brand, model, year, color, fuelType, fuelLevel, speed, isRunning);
        this.engineCC = engineCC;
        this.hasSidecar = hasSidecar;
        this.helmetCount = helmetCount;
    }

    public void popWheelie() {
        if (hasSidecar) {
            System.out.println("Cannot pop wheelie: Sidecar attached.");
            return;
        }
        
        if (getSpeed() >= 20) {
            System.out.println("Popping a wheelie!");
        } else {
            System.out.println("Too slow to pop a wheelie. Speed up to at least 20.");
        }
    }

    @Override
    public double getKmPerLiter() {
        // High efficiency default, unless overridden in constructor logic or field
        // For simplicity, we return a standard high value or derived from CC.
        if (engineCC > 1000) return 15.0; // Heavy bike
        return 35.0; // Standard bike
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("====== Motorcycle Information ======");
        System.out.println("Engine CC:    " + this.engineCC);
        System.out.println("Has Sidecar:  " + this.hasSidecar);
        System.out.println("Helmets:      " + this.helmetCount);
    }
    
    // Getters and Setters
    public int getEngineCC() { return engineCC; }
    public void setEngineCC(int engineCC) { this.engineCC = engineCC; }
    public boolean isHasSidecar() { return hasSidecar; }
    public void setHasSidecar(boolean hasSidecar) { this.hasSidecar = hasSidecar; }
    public int getHelmetCount() { return helmetCount; }
    public void setHelmetCount(int helmetCount) { this.helmetCount = helmetCount; }
}