package com.pluralsight;

import java.util.Scanner;

public class AddressApp
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        StringBuilder builder = new StringBuilder();
        String name;
        String billingStreet;
        String billingCity;
        String billingState;
        String billingZip;
        String shippingStreet;
        String shippingCity;
        String shippingState;
        String shippingZip;

        // input
        System.out.println();
        System.out.println("Please provide the following information:");
        name = getInput("Full name: ");
        System.out.println();
        billingStreet = getInput("Billing Street: ");
        billingCity = getInput("Billing City: ");
        billingState = getInput("Billing State: ");
        billingZip = getInput("Billing Zip: ");
        System.out.println();
        shippingStreet = getInput("Shipping Street: ");
        shippingCity = getInput("Shipping City: ");
        shippingState = getInput("Shipping State: ");
        shippingZip = getInput("Shipping Zip: ");

        // format using StringBuilder
        builder.append(name + "\n\n");
        builder.append("Billing Address:\n");
        builder.append(billingStreet + "\n");
        builder.append(billingCity + ", " + billingState + " " + billingZip);
        builder.append("\n\n");
        builder.append("Shipping Address:\n");
        builder.append(shippingStreet + "\n");
        builder.append(shippingCity + ", " + shippingState + " " + shippingZip);
        builder.append("\n\n");

        // display output
        System.out.println();
        System.out.println(builder);
    }

    public static String getInput(String message)
    {
        System.out.print(message);
        return userInput.nextLine().strip();
    }
}
