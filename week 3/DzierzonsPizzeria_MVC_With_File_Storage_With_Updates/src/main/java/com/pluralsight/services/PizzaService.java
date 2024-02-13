package com.pluralsight.services;

import com.pluralsight.models.Pizza;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PizzaService
{
    private static final String FILE_PATH = "data/pizzas.csv";
    private static int currentPizzaId = 1;
    private ArrayList<Pizza> pizzas;

    public PizzaService()
    {
        currentPizzaId = getLastOrderNumber() + 1;
        pizzas = loadPizzas();
    }

    private int getLastOrderNumber()
    {
        File ordersFile = new File(FILE_PATH);
        int pizzaId = 1;

        try(Scanner fileScanner = new Scanner(ordersFile))
        {
            fileScanner.nextLine();
            while (fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] columns = line.split(",");
                pizzaId = Integer.parseInt(columns[1]);
            }
        }
        catch(IOException ex)
        {
        }

        return pizzaId;
    }

    private ArrayList<Pizza> loadPizzas()
    {
        ArrayList<Pizza> pizzas = new ArrayList<>();

        File file = new File(FILE_PATH);

        try(Scanner scanner = new Scanner(file))
        {
            scanner.nextLine()
            ;
            while(scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] columns = line.split(",");

                // get pizza details from each line in the file
                int pizzaId = Integer.parseInt(columns[0]);
                int orderId = Integer.parseInt(columns[1]);
                String size = columns[2];
                String sauce = columns[3];
                String cheese = columns[4];
                String[] toppings = columns[5].split("\\|");

                //create the pizza
                Pizza pizza = new Pizza(pizzaId, orderId,size, sauce, cheese);
                //add any toppings
                for(String topping: toppings)
                {
                    pizza.addTopping(topping);
                }

                pizzas.add(pizza);
            }
        }
        catch (IOException e)
        {
        }

        return pizzas;
    }

    private void saveChanges()
    {
        // overwrite the entire file
        try(FileWriter fileWriter = new FileWriter(FILE_PATH, false))
        {
            PrintWriter pizzaWriter = new PrintWriter(fileWriter);
            // write header line
            pizzaWriter.println("pizza id,order id,size,sauce,cheese,toppings");

            for(Pizza pizza : pizzas)
            {
                pizzaWriter.println(pizza.toString());
            }
        }
        catch (IOException ex)
        {

        }
    }

    public void addPizza(int orderId, Pizza pizza)
    {
        pizza.setPizzaId(currentPizzaId++);
        pizza.setOrderId(orderId);

        try(FileWriter fileWriter = new FileWriter(FILE_PATH, true))
        {
            PrintWriter pizzaWriter = new PrintWriter(fileWriter);
            pizzaWriter.println(pizza.toString());
            pizzas.add(pizza);
        }
        catch (IOException ex)
        {

        }
    }

    public Pizza getPizzaById(int pizzaId)
    {
        for(Pizza pizza : pizzas)
        {
            if(pizza.getPizzaId() == pizzaId)
            {
                return pizza;
            }
        }

        return null;
    }

    public ArrayList<Pizza> findByOrderId(int orderId)
    {
        ArrayList<Pizza> orderPizzas = new ArrayList<>();

        for(Pizza pizza: pizzas)
        {
            if(pizza.getOrderId() == orderId)
            {
                orderPizzas.add(pizza);
            }
        }

        return orderPizzas;
    }

    public void updatePizza(int pizzaId, Pizza updatedPizza)
    {
        for(Pizza pizza : pizzas)
        {
            if(pizza.getPizzaId() == pizzaId)
            {
                // update all pizza settings
                pizza.setSize(updatedPizza.getSize());
                pizza.setSauce(updatedPizza.getSauce());
                pizza.setCheese(updatedPizza.getCheese());
                pizza.clearToppings();
                for(String topping : updatedPizza.getToppings())
                {
                    pizza.addTopping(topping);
                }
            }
        }

        // overwrite file with changes
        saveChanges();
    }

    public void deletePizza(int pizzaId)
    {
        Pizza currentPizza = getPizzaById(pizzaId);
        pizzas.remove(currentPizza);

        // overwrite the file without the deleted pizza
        saveChanges();
    }

}
