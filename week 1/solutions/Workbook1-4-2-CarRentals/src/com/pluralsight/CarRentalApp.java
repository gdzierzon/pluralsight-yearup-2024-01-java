package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CarRentalApp
{
    private static Scanner userInput = new Scanner(System.in);
    private static final double RENTAL_RATE = 29.99;
    private static final double TOLL_RATE = 3.95;
    private static final double GPS_RATE = 2.95;
    private static final double ROADSIDE_RATE = 3.95;

    public static void main(String[] args)
    {
        LocalDate pickupDate;
        int numberOfDays;
        boolean hasToll;
        boolean hasGps;
        boolean hasRoadside;
        int age;

        double basicRate;
        double tollCost;
        double gpsCost;
        double roadSideCost;
        double optionalCost;
        double underAgeSurcharge;
        double total;

        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println("Car Rentals");
        System.out.println("-".repeat(40));
        System.out.println();

        // get input
        pickupDate = getInputDate("What is your birthdate (mm/dd/yyyy)? ");
        numberOfDays = getInputInt("How many days is this rental for? ");
        hasToll = getInputBoolean("Do you want to include a toll tag (y/n)? ");
        hasGps = getInputBoolean("Do you want to include a GPS (y/n)? ");
        hasRoadside = getInputBoolean("Do you want to include a roadside assistance (y/n)? ");
        age = getInputInt("What is your age? ");

        // calculate
        basicRate = RENTAL_RATE * numberOfDays;
        tollCost = hasToll ? TOLL_RATE * numberOfDays : 0;
        gpsCost = hasGps ? GPS_RATE * numberOfDays : 0;
        roadSideCost = hasRoadside ? ROADSIDE_RATE * numberOfDays : 0;
        optionalCost = tollCost + gpsCost + roadSideCost;
        underAgeSurcharge = (age < 25) ? basicRate * .3 : 0;
        total = basicRate + underAgeSurcharge + optionalCost;

        // Display Contract
        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println("Rental Contract");
        System.out.println("-".repeat(40));
        System.out.printf("Renter Age:     %d \n", age);
        System.out.printf("Pickup Date:    %tD, %tB %td, %tY \n", pickupDate, pickupDate, pickupDate, pickupDate);
        System.out.printf("Number of days: %d \n", numberOfDays);
        System.out.printf("Base Rate:      %.2f \n", basicRate);
        System.out.printf("Toll Rate:      %.2f \n", tollCost);
        System.out.printf("GPS Rate:       %.2f \n", gpsCost);
        System.out.printf("Roadside Rate:  %.2f \n", roadSideCost);
        System.out.printf("Age Surcharge:  %.2f \n", underAgeSurcharge);
        System.out.println("-".repeat(40));
        System.out.printf("Total Cost:     %.2f \n", total);
    }

    public static String getInput(String message)
    {
        System.out.print(message);
        return userInput.nextLine().strip();
    }

    public static int getInputInt(String message)
    {
        return Integer.parseInt(getInput(message));
    }

    public static boolean getInputBoolean(String message)
    {
        String input = getInput(message).toLowerCase();
        return input.equals("y");
    }

    public static LocalDate getInputDate(String message)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(getInput(message), formatter);
    }
}
