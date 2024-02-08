package com.pluralsight;

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
        // get name
        String name = ui.getCustomerName();
        ui.displayBeginOrder();

        // build pizza
        Pizza pizza = new Pizza();
        pizza.setSize(ui.getPizzaSize());
        pizza.setSauce(ui.getSauce());
        pizza.setCheese(ui.getCheese());
        pizza.setToppings(ui.getToppings());

        // display order
        ui.displayOrder(name, pizza);

    }
}
