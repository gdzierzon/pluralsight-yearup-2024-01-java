package com.pluralsight.views;

import com.pluralsight.models.Order;
import com.pluralsight.models.Pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput
{
    Scanner scanner = new Scanner(System.in);

    public void displayHomeScreen()
    {
        System.out.println();
        System.out.println("Welcome to Dzierzon's Pizzeria");
        System.out.println("------------------------------");
        System.out.println();
    }

    public String getCustomerName()
    {
        System.out.print("Please enter your name (or exit to quit): ");
        String name = scanner.nextLine().strip();
        System.out.println();

        return name;
    }


    public boolean askToAddPizza()
    {
        System.out.print("Do you want to add a pizza (y/n)? ");
        String addToppings = scanner.nextLine().strip();

        return addToppings.equalsIgnoreCase("y");
    }


    public void displayBeginNewPizza()
    {
        System.out.println("New Pizza");
        System.out.println("---------------");
    }

    public String getPizzaSize()
    {
        System.out.println("Pizza Sizes:");
        System.out.println(" (S)mall  - $ 5.99");
        System.out.println(" (M)edium - $ 8.99");
        System.out.println(" (L)arge  - $11.99");
        System.out.print("Select your pizza size: ");
        String size = scanner.nextLine().strip();
        System.out.println();

        return size;
    }

    public String getSauce()
    {
        System.out.println("Sauces:");
        System.out.println(" (T)omato");
        System.out.println(" (A)lfredo");
        System.out.println(" (B)BQ");
        System.out.print("Select your sauce: ");
        String sauce = scanner.nextLine().strip();
        System.out.println();

        return sauce;
    }

    public String getCheese(){
        System.out.println("Cheeses:");
        System.out.println(" (M)ozzerella");
        System.out.println(" (P)rovolone");
        System.out.println(" (A)merican");
        System.out.println(" (C)heddar");
        System.out.print("Select your cheese: ");
        String cheese = scanner.nextLine().strip();
        System.out.println();

        return cheese;}

    public boolean askToAddTopping()
    {
        System.out.print("Do you want to add a topping (y/n)? ");
        String addToppings = scanner.nextLine().strip();

        return addToppings.equalsIgnoreCase("y");
    }

    public String getTopping()
    {
        System.out.print("Enter the topping name ($1 per topping): ");
        return scanner.nextLine().strip();
    }

    public void displayOrder(Order order)
    {
        System.out.println();
        System.out.println("-".repeat(20));
        System.out.println("Order Details ");
        System.out.println("-".repeat(20));
        System.out.println("Order Id: " + order.getOrderId());
        System.out.println("Name:   " + order.getName());

        for(Pizza pizza : order.getPizzas())
        {
            displayPizza(pizza);
        }

        System.out.println();
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();

    }

    public void displayPizza(Pizza pizza)
    {
        System.out.println();
        System.out.println("Pizza: ");
        System.out.println("-".repeat(20));
//        System.out.println("Name:   " + name);
        System.out.printf( "Price:  $ %.2f \n", pizza.getTotalPrice());
        System.out.println("Size:   " + pizza.getSize());
        System.out.println("Sauce:  " + pizza.getSauce());
        System.out.println("Cheese: " + pizza.getCheese());

        // if we have toppings (if toppings are not empty)
        if(!pizza.getToppings().isEmpty())
        {
            displayToppings(pizza.getToppings());
        }
    }

    public void displayToppings(ArrayList<String> toppings)
    {
        System.out.println("Toppings:");
        for(String topping : toppings)
        {
            System.out.println("  " + topping);
        }
    }
}
