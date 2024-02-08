package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzeriaApplication
{
    private final double TOPPING_PRICE = 1.5;

    public void run()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to Dzierzon'z Pizzeria");
        System.out.println("------------------------------");
        System.out.println();

        // get name
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().strip();
        System.out.println();

        System.out.println("Menu");
        System.out.println("---------------");

        // pizza size
        System.out.println("Pizza Sizes:");
        System.out.println(" (S)mall  - $ 5.99");
        System.out.println(" (M)edium - $ 8.99");
        System.out.println(" (L)arge  - $11.99");
        System.out.print("Select your pizza size: ");
        String size = scanner.nextLine().strip();
        System.out.println();

        // sauces
        System.out.println("Sauces:");
        System.out.println(" (T)omato");
        System.out.println(" (A)lfredo");
        System.out.println(" (B)BQ");
        System.out.print("Select your sauce: ");
        String sauce = scanner.nextLine().strip();
        System.out.println();

        // cheeses
        System.out.println("Cheeses:");
        System.out.println(" (M)ozzerella");
        System.out.println(" (P)rovolone");
        System.out.println(" (A)merican");
        System.out.println(" (C)heddar");
        System.out.print("Select your cheese: ");
        String cheese = scanner.nextLine().strip();
        System.out.println();

        // toppings
        ArrayList<String> toppings = new ArrayList<>();

        System.out.print("Do you want to add a topping (y/n)? ");
        String addToppings = scanner.nextLine().strip();

        while(addToppings.equalsIgnoreCase("y"))
        {
            System.out.print("Enter a topping name ($1 per topping): ");
            String topping = scanner.nextLine().strip();
            toppings.add(topping);

            System.out.print("Do you want to add another topping (y/n)? ");
            addToppings = scanner.nextLine().strip();
        }

        // calculate price
        double basePrice = 5.99;
        String sizeDisplay = "Small";

        if(size.equalsIgnoreCase("m"))
        {
            basePrice = 8.99;
            sizeDisplay = "Medium";
        }
        else if(size.equalsIgnoreCase("l"))
        {
            basePrice = 11.99;
            sizeDisplay = "Large";
        }

        double totalPrice = basePrice + (toppings.size() * TOPPING_PRICE);

        // display values
        String sauceDisplay = "Tomato";

        if(sauce.equalsIgnoreCase("a")) sauceDisplay = "Alfredo";
        else if(sauce.equalsIgnoreCase("b")) sauceDisplay = "BBQ";

        String cheeseDisplay = "Mozzarella";

        if(cheese.equalsIgnoreCase("p")) cheeseDisplay = "Provolone";
        else if(cheese.equalsIgnoreCase("a")) cheeseDisplay = "American";
        else if(cheese.equalsIgnoreCase("c")) cheeseDisplay = "Cheddar";


        // display order
        System.out.println();
        System.out.println("Order Details: ");
        System.out.println("-".repeat(20));
        System.out.println("Name:   " + name);
        System.out.printf( "Price:  $ %.2f \n", totalPrice);
        System.out.println("Size:   " + sizeDisplay);
        System.out.println("Sauce:  " + sauceDisplay);
        System.out.println("Cheese: " + cheeseDisplay);
        System.out.println("Toppings:");
        for(String topping : toppings)
        {
            System.out.println("  " + topping);
        }
    }
}
