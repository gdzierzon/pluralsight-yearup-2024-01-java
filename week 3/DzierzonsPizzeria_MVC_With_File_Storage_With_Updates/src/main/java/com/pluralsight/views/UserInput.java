package com.pluralsight.views;

import com.pluralsight.models.DeliveryOrder;
import com.pluralsight.models.DineInOrder;
import com.pluralsight.models.Order;
import com.pluralsight.models.Pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput
{
    Scanner scanner = new Scanner(System.in);

    public int displayHomeScreen()
    {
        System.out.println();
        System.out.println("Welcome to Dzierzon's Pizzeria");
        System.out.println("------------------------------");
        System.out.println("What do you want to do?");
        System.out.println(" 1) Start new order");
        System.out.println(" 2) Get order status");
        System.out.println(" 3) Update order status");
        System.out.println(" 0) Exit");
        System.out.print("Enter your selection: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public String getCustomerName()
    {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().strip();
        System.out.println();

        return name;
    }

    public String getReservationTime()
    {
        System.out.print("Enter a reservation time (hh:mm): ");
        return scanner.nextLine().strip();
    }

    public int getNumberOfGuests()
    {
        System.out.print("How many guests: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }

    public int getTableNumber()
    {
        System.out.print("Enter the table number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }

    public String getServerName()
    {
        System.out.print("Enter the server name: ");
        return scanner.nextLine().strip();
    }

    public String getUserInput(String message)
    {
        System.out.print(message);
        return scanner.nextLine().strip();
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

    public void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    public void displayOrder(Order order)
    {
        System.out.println();
        System.out.println("-".repeat(20));
        System.out.println("Order Details ");
        System.out.println("-".repeat(20));
        System.out.println("Order Id: " + order.getOrderId());
        System.out.println("Status:   " + order.getProgress());
        System.out.println("Name:     " + order.getName());
        // check if this is a DineInOrder
        if(order instanceof DineInOrder)
        {
            // typecast the order to a dineInOrder
            System.out.println();
            System.out.println("Reservation Information");
            System.out.println("----------------------------------");
            DineInOrder dineInOrder = (DineInOrder)order;
            System.out.println("Reservation time: " + dineInOrder.getReservationTime());
            System.out.println("Number of Guests: " + dineInOrder.getNumberOfGuests());
            System.out.println("Table Number: " + dineInOrder.getTable());
            System.out.println("Server: " + dineInOrder.getServer());
        }
        if(order instanceof DeliveryOrder)
        {
            System.out.println();
            System.out.println("Delivery Information");
            System.out.println("----------------------------------");
            DeliveryOrder deliveryOrder = (DeliveryOrder)order;
            System.out.println("Address:    " + deliveryOrder.getAddress());
            System.out.println("Apartment:  " + deliveryOrder.getApartment());
            System.out.println("City:       " + deliveryOrder.getCity());
            System.out.println("State:      " + deliveryOrder.getState());
            System.out.println("Zip Code:   " + deliveryOrder.getZip());
        }

        for(Pizza pizza : order.getPizzas())
        {
            displayPizza(pizza);
        }

        System.out.println();
        // display delivery charge ONLY if it is a delivery order
        if(order instanceof DeliveryOrder)
        {
            DeliveryOrder deliveryOrder = (DeliveryOrder)order;
            System.out.printf("Delivery Charge:   $ %.2f \n",  deliveryOrder.getDeliveryCharge());
        }
        System.out.printf("Order Total:       $ %.2f \n", order.getTotal());

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

    public String getOrderType()
    {
        System.out.println("What type or order is this for?");
        System.out.println(" 1) dine-in ");
        System.out.println(" 2) delivery ");
        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        // ternary operator ?:
        // (if condition) ? value if true : value if false
        return (option == 1)
                ? "DineIn"
                : "Delivery";
    }
}
