package com.pluralsight;

import java.util.Scanner;

public class SandwichShopApp
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        // declare variables
        int sandwichSize;
        int age;
        double subTotal;
        double discount;
        double total;

        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println("Sandwich Shop");
        System.out.println("-".repeat(40));
        System.out.println();

        // get user input
        displayMenu();
        sandwichSize = getInputInt("Please select a size: ");
        age = getInputInt("What is your age? ");

        // calculate price
        subTotal = (sandwichSize == 1)
                        ? 5.45
                        : 8.95;
        discount = getDiscount(age);
        total = subTotal - (subTotal * discount);

        // display order
        System.out.println();
        System.out.println("Order Details");
        System.out.println("-".repeat(20));
        System.out.printf("Base Price: $ %.2f \n", subTotal);
        System.out.printf("Discount:   $ %.2f \n", (subTotal * discount));
        System.out.println("-".repeat(20));
        System.out.printf("Total:      $ %.2f \n", total);
        System.out.println();
    }

    public static void displayMenu()
    {
        System.out.println("Menu");
        System.out.println("-".repeat(40));
        System.out.println("  1) Regular: base price $5.45");
        System.out.println("  2) Large: base price $8.95");
        System.out.println("-".repeat(40));
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

    public static double getDiscount(int age)
    {
        if (age<= 17) return .1;
        else if (age >= 65) return .2;
        else return 0;
    }
}
