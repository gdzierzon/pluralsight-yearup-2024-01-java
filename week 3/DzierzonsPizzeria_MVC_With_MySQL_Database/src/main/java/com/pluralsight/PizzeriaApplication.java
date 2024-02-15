package com.pluralsight;

import com.pluralsight.models.DeliveryOrder;
import com.pluralsight.models.DineInOrder;
import com.pluralsight.models.Order;
import com.pluralsight.models.Pizza;
import com.pluralsight.services.*;
import com.pluralsight.views.UserInput;

// PizzaApplication acts as the controller
// it is responsible for the logical flow of the application
public class PizzeriaApplication
{
    UserInput ui = new UserInput();
    OrdersService orderService;
    PizzaService pizzaService;

    public PizzeriaApplication(OrdersService orderService, PizzaService pizzaService)
    {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }


    public void run()
    {

        // each loop creates a new customer order
        while(true)
        {
            int choice = ui.displayHomeScreen();
            if(choice == 1)
            {
                startOrder();
            }
            else if(choice == 2)
            {
                // search for existing order
                searchForOrder();
            }
            else if(choice == 3) // update status
            {
                updateOrder();
            }
            else if(choice == 0)
            {
                break;
            }

        }

    }

    public void updateOrder()
    {
        int orderId = Integer.parseInt(ui.getUserInput("Enter order number: "));
        Order order = orderService.getByOrderId(orderId);

        if(order != null)
        {
            ui.displayMessage("Order " + order.getOrderId() + " status is: " + order.getProgress());
            String status = ui.getUserInput("Enter the new status: ");
            order.setProgress(status);
            orderService.updateOrder(orderId, order);
        }
        else {
            ui.displayMessage("The order was not found.");
        }
    }

    public void searchForOrder()
    {
        int orderId = Integer.parseInt(ui.getUserInput("Enter order number: "));
        Order order = orderService.getByOrderId(orderId);

        if(order != null)
        {
            ui.displayOrder(order);
        }
        else {
            ui.displayMessage("The order was not found.");
        }
    }

    public void startOrder()
    {
        // declare a General order that can add pizzas
        Order order;
        String name = ui.getCustomerName();

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
        orderService.addOrder(order);
        for(Pizza pizza: order.getPizzas())
        {
            pizzaService.addPizza(order.getOrderId(),pizza);
        }

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
