/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FractionPackage;

/**
 *
 * @author joopa04
 */
public class Fraction {
    private int numerator, denominator;

    
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    
    public void displayFraction() {
        System.out.println(numerator + "/" + denominator);
    }
    
    public boolean isAProperFraction() {
        return denominator != 0 && numerator <= denominator;
    }
    public Fraction getProduct(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }
    public Fraction getQuotient(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }
}
