/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActivityPackage;

/**
 *
 * @author joopa04
 */
public class PiggyBank {
    private String name;    
    private int tenPesos;
    private int fivePesos;
    private int onePeso;
    private int twentyFiveCents;
    
    /**
     * 
     * @param name string
     */
    public PiggyBank(String name) {
        this.name = name;
        this.tenPesos = 0;
        this.fivePesos = 0;
        this.onePeso = 0;
        this.twentyFiveCents = 0;
    }
    
    /**
     * 
     * @return 
     */
    public double getTotalMoney() {
        return (tenPesos * 10) + (fivePesos * 5) + (onePeso * 1) + (twentyFiveCents * 0.25);
    }
    
    /**
     * Reset object
     */
    public void emptyPiggy() {
        this.tenPesos = 0;
        this.fivePesos = 0;
        this.onePeso = 0;
        this.twentyFiveCents = 0;
    }
    
    /**
     * 
     * @param count
     */
    public void addPeso(int count) {
        if (count >= 0) {
            this.onePeso += count;
        } else {
            System.out.println("Mony must be non-negative.");
        }
    }
    
    /**
     * 
     * @param tensCount
     * @param fivesCount
     * @param onesCount
     * @param twentyFiveCentsCount 
     */
    public void addPeso(int tensCount, int fivesCount, int onesCount, int twentyFiveCentsCount) {
        if (tensCount < 0 || fivesCount < 0 || onesCount < 0 || twentyFiveCentsCount < 0) {
            System.out.println("Mony must be non-negative.");
        } else {
            this.tenPesos += tensCount;
            this.fivePesos += fivesCount;
            this.onePeso += onesCount;
            this.twentyFiveCents += twentyFiveCentsCount;
        }
    }
    
    /**
     * 
     * @param count
     * @param type 
     */
    public void addPeso(int count, String type) {
        if (count < 0) {
            System.out.println("Money must be non-negative.");
            return;
        }
        switch (type.toLowerCase()) {
            case "tens": this.tenPesos += count; break;
            case "fives": this.fivePesos += count; break;
            case "ones": this.onePeso += count; break;
            case "cents": this.twentyFiveCents += count; break;
            default:
                System.out.println("Can only accept types: tens, fives, ones, cents");
        }
    }
}
