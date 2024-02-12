package com.pluralsight.services;

import com.pluralsight.models.Pizza;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
}
