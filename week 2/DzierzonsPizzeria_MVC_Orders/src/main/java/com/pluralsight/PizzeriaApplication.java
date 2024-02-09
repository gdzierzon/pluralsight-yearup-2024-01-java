package com.pluralsight;

import com.pluralsight.models.Order;
import com.pluralsight.models.Pizza;
import com.pluralsight.views.UserInput;

import java.util.ArrayList;
import java.util.Scanner;

// PizzaApplication acts as the controller
// it is responsible for the logical flow of the application
public class PizzeriaApplication
{
    UserInput ui = new UserInput();

    private final double TOPPING_PRICE = 1.5;


    public void run()
    {
        ui.displayHomeScreen();

        // each loop creates a new customer order
        while(true)
        {
            String name = ui.getCustomerName();
            if(name.equalsIgnoreCase("exit"))
            {
                break;
            }

            System.out.println("starting new order for " + name);
            startOrder(name);
        }

    }

    public void startOrder(String name)
    {
        Order order = new Order(name);
        // prompt to add a new pizza
        while(ui.askToAddPizza())
        {
            Pizza pizza = createPizza();
            order.addPizza(pizza);
        }

        // display the order details
        ui.displayOrder(order);

    }

    public Pizza createPizza()
    {
        ui.displayBeginNewPizza();
        // build pizza
        Pizza pizza = new Pizza();
        pizza.setSize(ui.getPizzaSize());
        pizza.setSauce(ui.getSauce());
        pizza.setCheese(ui.getCheese());

        while(ui.askToAddTopping())
        {
            ui.displayToppings(pizza.getToppings());
            String topping = ui.getTopping();
            pizza.addTopping(topping);
        }

        return pizza;
    }
}
