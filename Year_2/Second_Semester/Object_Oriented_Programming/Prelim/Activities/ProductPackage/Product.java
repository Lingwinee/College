/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductPackage;

/**
 *
 * @author joopa04
 */
public class Product {
    private int code, stock;
    private String name;
    private float uCost;

    public Product() {
        code = 100;
        name = "Place Holder";
        stock = 0;
        uCost = 0.00f;
    }

    public Product(int code, String name, int stock, float uCost) {
        if (validateCode(code)) {
            this.code = code;
        } else {
            System.out.println("Product code must be between 100 and 999. Defaulting to 100.");
            this.code = 100;
        }
        this.name = name;
        this.stock = stock;
        this.uCost = uCost;
    }

    private boolean validateCode(int code) {
        return code >= 100 && code <= 999;
    }
    
    // SETTERS ----------------------------------------
    public void setCode(int code) {
        if (validateCode(code)) {
            this.code = code;
        } else {
            System.out.println("Invalid code. Must be between 100 and 999.");
        }
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setuCost(float uCost) {
        this.uCost = uCost;
    }
    
    // GETTERS ----------------------------------------
    public int getCode() {
        return code;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public float getuCost() {
        return uCost;
    }
    
    // OPERATIONS -------------------------------------
    public void displayInfo() {
        System.out.println("==== Product Information ====");
        System.out.println("Code:\t\t" + code);
        System.out.println("Name:\t\t" + name);
        System.out.println("Cost:\t\t" + uCost);
        System.out.println("Quantity:\t" + stock);
    }

    public void increasePrice(float rate) {
        if (rate > 0){
            this.uCost += this.uCost * rate;
        } else {
            System.out.println("Increase must be positive.");
        }
    }

    public void purchaseStock(int amount) {
        if (amount > 0) {
            this.stock += amount;
        } else {
            System.out.println("Ammount to purchase cannot be negative.");
        }
    }

    public boolean isOutOfStock() {
        return this.stock <= 0;
    }

    public void sellProduct(int quantity) {
        if (isOutOfStock()) {
            System.out.println("Product is out of stock!");
        } else if (quantity > 0) {
            if (this.stock >= quantity) {
                this.stock -= quantity;
                System.out.println("Sold " + quantity + " units of " + name);
                System.out.println("Total price: " + quantity * this.uCost);
            } else {
                System.out.println("Not enough stock to sell " + quantity + " units.");
            }
        } else {
            System.out.println("Sale quantity must be positive.");
        }
    }
}
