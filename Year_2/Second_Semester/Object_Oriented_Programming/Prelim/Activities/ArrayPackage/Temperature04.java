/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArrayPackage;

/**
 *
 * @author joopa04
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class Temperature04 {
    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY,  AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }
    public static void main(String[] args){
        float[][] temperature = new float[12][2];

        getData(temperature);
        
        DecimalFormat df = new DecimalFormat("#0.00");
        
        System.out.println("\n--- Annual Temperature Report ---");
        for (int i = 0; i < 12; i++) {
            System.out.println("Month: " + Month.values()[i] + "\t\tLowest: " + df.format(temperature[i][0]) + "\tHighest: " + df.format(temperature[i][1]));
        }
        System.out.println();

        System.out.println("Average Lowest temperature: " + df.format(averageLow(temperature)));
        System.out.println("Average Highest temperature: " + df.format(averageHigh(temperature)));

        int lowIndex = indexLowTemp(temperature);
        int highIndex = indexHighTemp(temperature);
        
        System.out.printf("Lowest temperature: %.2f (%s or Index: %d)\n", temperature[lowIndex][0], Month.values()[lowIndex], lowIndex + 1);
        System.out.printf("Highest temperature: %.2f (%s or Index: %d)\n", temperature[highIndex][1], Month.values()[highIndex], highIndex + 1);
    }
    
    public static void getData(float[][] temperature) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 12; i++) {
            System.out.println("Enter Lowest and Highest Temp for " + Month.values()[i] + ": ");
            System.out.print("\tLowest: ");
            temperature[i][0] = input.nextFloat();
            System.out.print("\tHighest: ");
            temperature[i][1] = input.nextFloat();
            
            if (temperature[i][0] > temperature[i][1]){
                float temp = temperature[i][1];
                temperature[i][1] = temperature[i][0];
                temperature[1][0] = temp;
                System.out.println("Values Swapped Highest Temp is lower than Lowest Temp.\n");
            }
        }
        input.close();
    }
    
    public static float averageLow(float[][] temperature) {
        float sum = 0;
        for(int i = 0; i < 12; i++) {
            sum += temperature[i][0];
        }
        return sum / 12;
    }
    
    public static float averageHigh(float[][] temperature) {
        float sum = 0;
        for(int i = 0; i < 12; i++) {
            sum += temperature[i][1];
        }
        return sum / 12;
    }
    
    public static int indexLowTemp(float[][] temperature) {
        float lowest = temperature[0][0];
        int index = 0;
        for (int i = 1; i < 12; i++) {
            if (temperature[i][0] < lowest) {
                lowest = temperature[i][0];
                index = i;
            }
        }
        return index;
    }
    
    public static int indexHighTemp(float[][] temperature) {
        float lowest = temperature[0][0];
        int index = 0;
        for (int i = 1; i < 12; i++) {
            if (temperature[i][0] < lowest) {
                lowest = temperature[i][1];
                index = i;
            }
        }
        return index;
    }
}
