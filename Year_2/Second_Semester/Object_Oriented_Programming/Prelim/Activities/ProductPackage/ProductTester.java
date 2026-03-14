/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductPackage;

/**
 *
 * @author joopa04
 */

public class ProductTester {
    public static void main(String[] args) {
        // Test default constructor
        Product prod1 = new Product();
        System.out.println("Testing default constructor:");
        prod1.displayInfo();

        // Test parameterized constructor with valid code
        Product prod2 = new Product(456, "Juswa", 1, 100000);
        System.out.println("\nTesting parameterized constructor with valid code:");
        prod2.displayInfo();

        // Test parameterized constructor with invalid code
        Product prod3 = new Product(50, "InvalidCodeProduct", 5, 10.5f);
        System.out.println("\nTesting parameterized constructor with invalid code:");
        prod3.displayInfo();

        // Test setters
        System.out.println("\nTesting setters:");
        prod1.setCode(500);
        prod1.setName("Mattskie");
        prod1.setStock(20);
        prod1.setuCost(1.0f);
        prod1.displayInfo();

        // Test getters
        System.out.println("\nTesting getters:");
        System.out.println("Code: " + prod1.getCode());
        System.out.println("Name: " + prod1.getName());
        System.out.println("Stock: " + prod1.getStock());
        System.out.println("Unit Cost: " + prod1.getuCost());

        // Test increasePrice
        System.out.println("\nTesting increasePrice:");
        prod1.increasePrice(0.10f); // increase by 10%
        prod1.displayInfo();
        prod1.increasePrice(-0.05f); // invalid increase

        // Test purchaseStock
        System.out.println("\nTesting purchaseStock:");
        prod1.purchaseStock(5);
        prod1.displayInfo();
        prod1.purchaseStock(-3); // invalid purchase

        // Test isOutOfStock
        System.out.println("\nTesting isOutOfStock:");
        System.out.println("Is prod1 out of stock? " + prod1.isOutOfStock());
        System.out.println("Is prod2 out of stock? " + prod2.isOutOfStock());

        // Test sellProduct
        System.out.println("\nTesting sellProduct:");
        prod1.sellProduct(10); // valid sale
        prod1.displayInfo();
        prod1.sellProduct(50); // not enough stock
        prod1.sellProduct(-5); // invalid sale
        prod2.sellProduct(1);  // selling last unit
        prod2.sellProduct(1);  // now out of stock
    }
}
