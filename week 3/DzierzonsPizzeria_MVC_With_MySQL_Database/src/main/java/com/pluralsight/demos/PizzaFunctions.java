package com.pluralsight.demos;

import com.pluralsight.models.Pizza;
import com.pluralsight.services.FilePizzaService;
import com.pluralsight.views.UserInput;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaFunctions
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        FilePizzaService pizzaService = new FilePizzaService();
        UserInput ui = new UserInput();

        System.out.print("What is the order number? ");
        int orderId = userInput.nextInt();
        userInput.nextLine();

        ArrayList<Pizza> pizzas = pizzaService.findByOrderId(orderId);

        for(Pizza pizza : pizzas)
        {
            ui.displayPizza(pizza);
        }
    }
}
