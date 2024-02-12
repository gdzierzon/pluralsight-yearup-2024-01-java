package com.pluralsight;

import com.pluralsight.models.DeliveryOrder;
import com.pluralsight.models.DineInOrder;
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

            startOrder(name);
        }

    }

    public void startOrder(String name)
    {
        // declare a General order that can add pizzas
        Order order;

        String type = ui.getOrderType();
        if(type.equals("DineIn"))
        {
            // create a specialized DineInOrder - so that we can set the dining preferences
            DineInOrder dineInOrder = new DineInOrder(name);
            dineInOrder.setReservationTime(ui.getReservationTime());
            dineInOrder.setNumberOfGuests(ui.getNumberOfGuests());
            dineInOrder.setTable(ui.getTableNumber());
            dineInOrder.setServer(ui.getServerName());

            // point the general order to the DineInOrder
            order = dineInOrder;
        }
        else {
            // create a Deliver Order
            DeliveryOrder deliveryOrder = new DeliveryOrder(name);
            deliveryOrder.setAddress(ui.getUserInput("Enter street address: "));
            deliveryOrder.setApartment(ui.getUserInput("Enter apartment: "));
            deliveryOrder.setCity(ui.getUserInput("Enter city: "));
            deliveryOrder.setState(ui.getUserInput("Enter state: "));
            deliveryOrder.setZip(ui.getUserInput("Enter zip code: "));

            // create a delivery order
            order = deliveryOrder;
        }

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
