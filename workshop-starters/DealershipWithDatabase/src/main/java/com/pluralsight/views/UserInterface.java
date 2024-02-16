package com.pluralsight.views;

import com.pluralsight.models.Car;
import com.pluralsight.models.Dealer;

import java.util.List;
import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);

    public Dealer homeScreenGetDealerId(List<Dealer> dealers)
    {
        System.out.println();
        System.out.println("Please select a dealer:");
        for(Dealer dealer: dealers)
        {
            System.out.println("  " + dealer.getId() + ") " + dealer.getName());
        }
        System.out.println("  99) Exit");
        System.out.print("Enter your selection: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for(Dealer dealer: dealers)
        {
            if(dealer.getId() == id) return dealer;
        }

        return null;
    }

    public void goodBye()
    {
        System.out.println();
        System.out.println("Good Bye");
        System.out.println();
    }

    public int dealerHomeScreen(Dealer dealer)
    {
        System.out.println();
        System.out.println("Welcome to " + dealer.getName());
        System.out.println("----------------------------------");
        System.out.println("What would you like to do? ");
        System.out.println("  1) Search vehicles by price");
        System.out.println("  2) Search vehicles by make / model");
        System.out.println("  3) Search vehicles by year");
        System.out.println("  4) Search vehicles by color");
        System.out.println("  5) Search vehicles by mileage");
        System.out.println("  6) Search vehicles by type (Sedan, Truck, SUV, Hybrid, Electric)");
        System.out.println("  7) List ALL vehicles");
        System.out.println("  8) Add a vehicle");
        System.out.println("  9) Remove a vehicle");
        System.out.println("  99) Exit");
        System.out.print("Enter your selection: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public void showCars(List<Car> cars)
    {
        System.out.println();
        System.out.println("Search Results");
        System.out.println("---------------------");
        for(Car car : cars)
        {
            System.out.printf("%d %s %s %s $%.2f \n", car.getYear(), car.getColor(), car.getMake(), car.getModel(), car.getPrice());
        }

        System.out.println();
        System.out.println("Press ENTER to continue...");
        scanner.nextLine();
    }

    public String getString(String message)
    {
        System.out.print(message);
        return scanner.nextLine().strip();
    }

    public int getInt(String message)
    {
        String input = getString(message);
        return Integer.parseInt(input);
    }
}
