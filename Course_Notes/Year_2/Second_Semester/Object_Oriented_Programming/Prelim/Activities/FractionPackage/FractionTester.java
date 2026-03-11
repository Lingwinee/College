/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FractionPackage;

/**
 *
 * @author joopa04
 */
public class FractionTester {
    public static void main(String[] args) {
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();
        Fraction frac3 = new Fraction();

        // Initialize 
        frac1.setNumerator(1);
        frac1.setDenominator(4);
        frac2.setNumerator(3);
        frac2.setDenominator(2);
        frac3.setNumerator(10);
        frac3.setDenominator(5);

        // Display with getters
        System.out.println("Fraction 1: " + frac1.getNumerator() + "/" + frac1.getDenominator());
        System.out.println("Fraction 2: " + frac2.getNumerator() + "/" + frac2.getDenominator());
        System.out.println("Fraction 3: " + frac3.getNumerator() + "/" + frac3.getDenominator());

        System.out.println();

        // Display 
        System.out.print("Fraction 1: ");
        frac1.displayFraction();
        System.out.println("Fraction 1 is a proper fraction: " + frac1.isAProperFraction()); 

        System.out.print("Fraction 2: "); 
        frac2.displayFraction(); 
        System.out.println("Fraction 2 is a proper fraction: " + frac2.isAProperFraction());

        System.out.print("Fraction 3: "); 
        frac3.displayFraction(); 
        System.out.println("Fraction 3 is a proper fraction: " + frac3.isAProperFraction());

        System.out.println();

        // Product
        Fraction product = frac1.getProduct(frac2);
        System.out.print("Product: ");
        product.displayFraction();

        // Quotient
        Fraction quotient = frac1.getQuotient(frac2);
        System.out.print("Quotient: ");
        quotient.displayFraction();
    }
}
