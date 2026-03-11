/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActivityPackage;

/**
 *
 * @author joopa04
 */
public class PiggyBankTester {
    public static void main(String[] args) {
        PiggyBank myPiggy = new PiggyBank("My Figgy");

        
        PiggyBank test = new PiggyBank("SHIT");
        
        test.addPeso(0, 0, 0, 0);
        
        // Test adding onePeso coins
        myPiggy.addPeso(5); // Add 5 onePeso coins
        System.out.println("After adding 5 onePeso coins: " + myPiggy.getTotalMoney());

        // Test adding multiple denominations at once
        myPiggy.addPeso(2, 3, 4, 10); // 2 tens, 3 fives, 4 ones, 10 cents
        System.out.println("After adding multiple denominations: " + myPiggy.getTotalMoney());

        // Test adding by type
        myPiggy.addPeso(3, "tens");   // Add 3 tenPeso coins
        myPiggy.addPeso(2, "fives");  // Add 2 fivePeso coins
        myPiggy.addPeso(7, "ones");   // Add 7 onePeso coins
        myPiggy.addPeso(20, "cents"); // Add 20 twentyFiveCents coins
        System.out.println("After adding by type: " + myPiggy.getTotalMoney());

        // Test invalid input (negative values)
        myPiggy.addPeso(-5); // Should print error message
        myPiggy.addPeso(-2, "tens"); // Should print error message
        myPiggy.addPeso(1, "invalidType"); // Should print error message

        // Show total before emptying
        System.out.println("Total before emptying: " + myPiggy.getTotalMoney());

        // Test emptyPiggy
        myPiggy.emptyPiggy();
        System.out.println("After emptying piggy: " + myPiggy.getTotalMoney());
    }
}


