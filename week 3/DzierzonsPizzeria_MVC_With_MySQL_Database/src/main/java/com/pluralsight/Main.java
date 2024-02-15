package com.pluralsight;

import com.pluralsight.models.Order;
import com.pluralsight.services.*;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class Main
{
    public static void main(String[] args)
    {
        // Through Dependency Injection we can use either database services...
        PizzaService pizzaService = new DatabasePizzaService();
        OrdersService orderService = new DatabaseOrdersService();

        // ... or file services to store our orders and pizzas
//        PizzaService pizzaService = new FilePizzaService();
//        OrdersService orderService = new FileOrdersService();

        PizzeriaApplication app = new PizzeriaApplication(orderService, pizzaService);
        app.run();


    }
}