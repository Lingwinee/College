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

public class Marathon04 {
    
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] runners_Name = new String[5];
        float[][] runners_Data = new float[5][7];

        inputNames(runners_Name, sc);
        inputMilesRun(runners_Data, runners_Name, sc);

        outputResults(runners_Name, runners_Data);
    }
    public static void inputNames(String[] names, Scanner sc) {
        System.out.println("Input names of runners: ");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.nextLine();
        } 
    }
    public static void inputMilesRun(float[][] data, String names[], Scanner sc) {
        System.out.println("Input no. of miles run per day each runner:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + ": ");
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = sc.nextFloat();
            }
        }
    }
    public static void outputResults(String names[], float[][] data) {
        System.out.println("\n--------------------------------------------------");
        System.out.printf("%-20s %-15s %-15s%n", "Name", "Total Miles", "Average");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < names.length; i++) {
            float total = 0.0f;

            for (int j = 0; j < 7; j++) {
                total += data[i][j];
            }

            float average = total / 7.0f;

            System.out.printf("%-20s %-15.2f %-15.2f%n", names[i], total, average);
        }
    }
}
