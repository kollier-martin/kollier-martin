package io.beansprout.CodingChallenges;

import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.Scanner;

public class RainfallData {
    private static final String[] months = new DateFormatSymbols().getMonths();
    private static final double[] monthValues = new double[12];
    private static final HashMap<Integer, String> monthValueKeyPair = new HashMap<>();

    public static void main(String[] args) {
        addRainfallData();

        System.out.println("The average rainfall for the year was " + averageRainfall() + " inches.");
        System.out.println("The lowest rainfall recorded for any month was " + lowestRainfallAmount() + " inches.");
        System.out.println("The name of the month with the lowest recorded rainfall was " + lowestRainfallMonth());
        System.out.println("The highest rainfall recorded for any month was " + highestRainfallAmount() + " inches.");
        System.out.println("The name of the month with the highest recorded rainfall was " + highestRainfallMonth());
    }

    /**
     * This method adds rainfall values to the array via  user input.
     */
    public static void addRainfallData() {
        try (Scanner scan = new Scanner(System.in)) {
            boolean complete = false;
            int i = 0;

            while (!complete) {
                if (i == 12) {
                    complete = true;
                } else {
                    System.out.println("Please enter an integer for the  rainfall on " + months[i] + ".");
                    double input = scan.nextDouble();
                    monthValues[i] = input;
                    monthValueKeyPair.put((int) input, months[i]);
                    i++;
                }
            }
        }
    }

    /**
     * This method computes the average rainfall for the year. Use a for loop
     * Recall that average is the sum of the array values divided by the number (count) of values.
     *
     * @return a double for the computed average
     */
    public static double averageRainfall() {
        double total = 0;

        for (double monthValue : monthValues) {
            total = total + monthValue;
        }

        return total / 12;
    }

    /**
     * This method finds the smallest value in the rainfall array
     *
     * @return the integer of the lowest rainfall in the array
     */
    public static int lowestRainfallAmount() {
        int low = (int) monthValues[0];

        for (double monthValue : monthValues) {
            if (monthValue < low) {
                low = (int) Math.round(monthValue);
            }
        }

        return low;
    }

    /**
     * This method finds the name of the month that matches the smallest value in the rainfall array
     *
     * @return the name of the month with the lowest rainfall in the array.
     */
    public static String lowestRainfallMonth() {
        return monthValueKeyPair.get(lowestRainfallAmount());
    }

    /**
     * This method finds the largest value in the rainfall array
     *
     * @return the integer of the largest rainfall in the array
     */
    public static int highestRainfallAmount() {
        int high = (int) monthValues[0];

        for (double monthValue : monthValues) {
            if (monthValue > high) {
                high = (int) Math.round(monthValue);
            }
        }

        return high;
    }

    /**
     * This method finds the name of the month that matches the largest value in the rainfall array
     *
     * @return the name of the month with the largest rainfall in the array.
     */
    public static String highestRainfallMonth() {
        return monthValueKeyPair.get(highestRainfallAmount());
    }
}
