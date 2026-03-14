/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FleetPackage;

/**
 *
 * @author joopa04
 */

import java.util.ArrayList;
import java.util.List;

public class FleetDemo {

    public static void main(String[] args) {

        // ── Build the Fleet ───────────────────────────────────────────────────

        Sedan sedan = new Sedan(
            "V001", "Toyota", "Vios", 2021, "Silver",
            FuelType.GAS, 80.0,
            4, "Automatic", 350.0,
            "Leather", true
        );

        SUV suv = new SUV(
            "V002", "Ford", "Everest", 2020, "Black",
            FuelType.DIESEL, 65.0,
            5, "Automatic", 550.0,
            true, 22.0, 500.0
        );

        Motorcycle moto = new Motorcycle(
            "V003", "Honda", "Click 125i", 2022, "Red",
            FuelType.GAS, 90.0,
            125, false, 2
        );

        Bus bus = new Bus(
            "V004", "Hino", "Coach 300", 2019, "Yellow",
            FuelType.DIESEL, 70.0,
            45, true, "USJ-R Route A", 200.0
        );

        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(sedan);
        fleet.add(suv);
        fleet.add(moto);
        fleet.add(bus);

        // ── Part 1: Polymorphic Fleet Loop ────────────────────────────────────

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        FLEET DEMO — POLYMORPHISM         ║");
        System.out.println("╚══════════════════════════════════════════╝");

        for (Vehicle v : fleet) {
            System.out.println("\n──── Processing: " + v.getVehicleId() + " ────");
            v.startEngine();
            v.accelerate(30);
            v.displayInfo();

            double cost = v.calculateTripCost(50, 70);
            System.out.printf("  Trip Cost (50 km @ ₱70/L): ₱%.2f%n", cost);
        }

        // ── Part 2: Maintainable Check ────────────────────────────────────────

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║           MAINTENANCE CHECK              ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // Simulate mileage to trigger maintenance on sedan and moto
        sedan.drive(5100);
        moto.drive(3100);

        for (Vehicle v : fleet) {
            if (v instanceof Maintainable) {
                Maintainable m = (Maintainable) v;  // explicit cast
                System.out.println("\n[" + v.getVehicleId() + "] Needs maintenance? " + m.needsMaintenance());
                if (m.needsMaintenance()) {
                    m.performMaintenance();
                }
            }
        }

        // ── Part 3: PassengerCarrier Test ─────────────────────────────────────

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║        PASSENGER CARRIER TEST            ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        for (Vehicle v : fleet) {
            if (v instanceof PassengerCarrier) {
                PassengerCarrier pc = (PassengerCarrier) v;  // explicit cast
                System.out.println("[" + v.getVehicleId() + "] Capacity: " + pc.getPassengerCapacity());
                pc.board(30);
                pc.board(20);   // Should fill up or warn if over capacity
                pc.alight(10);
                System.out.println("[" + v.getVehicleId() + "] Current passengers: " + pc.getCurrentPassengers());
            }
        }

        // ── Part 4: CargoCarrier Test ─────────────────────────────────────────

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║          CARGO CARRIER TEST              ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        for (Vehicle v : fleet) {
            if (v instanceof CargoCarrier) {
                CargoCarrier cc = (CargoCarrier) v;  // explicit cast
                System.out.println("[" + v.getVehicleId() + "] Max cargo: " + cc.getMaxCargoKg() + " kg");
                cc.loadCargo(150.0);
                cc.loadCargo(400.0);   // Attempt to overload
                cc.unloadCargo(50.0);
                System.out.printf("[%s] Current cargo: %.1f kg%n", v.getVehicleId(), cc.getCurrentCargoKg());
            }
        }

        // ── Part 5: Insurable — Annual Insurance Quote ────────────────────────

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║        ANNUAL INSURANCE QUOTES           ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        for (Vehicle v : fleet) {
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;  // explicit cast
                double quote = ins.calculateAnnualInsurance();
                System.out.printf("[%s] Annual Insurance: ₱%,.2f (rate: %.0f%%)%n",
                                  v.getVehicleId(), quote, ins.getInsuranceRate() * 100);
            }
        }

        // ── Bonus: Motorcycle Wheelie ─────────────────────────────────────────

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║           MOTORCYCLE WHEELIE             ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        moto.popWheelie();   // Speed is already 30 km/h from earlier
    }
}