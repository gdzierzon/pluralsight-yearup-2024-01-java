package com.pluralsight.services;

import com.pluralsight.models.Pizza;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaService
{
    private static final String FILE_PATH = "data/pizzas.csv";

    public void addPizza(int orderId, Pizza pizza)
    {
        try(FileWriter fileWriter = new FileWriter(FILE_PATH, true))
        {
            PrintWriter pizzaWriter = new PrintWriter(fileWriter);
            pizzaWriter.println(orderId +","+ pizza.toString());
        }
        catch (IOException ex)
        {

        }
    }

    public ArrayList<Pizza> loadPizzas()
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
            }
        }
        catch (IOException e)
        {
        }

        return pizzas;
    }
}
