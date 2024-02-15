package com.pluralsight;

import com.pluralsight.models.Order;
import com.pluralsight.services.DatabaseOrdersService;
import com.pluralsight.services.DatabasePizzaService;
import com.pluralsight.services.OrdersService;
import com.pluralsight.services.PizzaService;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class Main
{
    public static void main(String[] args)
    {
        PizzaService pizzaService = new DatabasePizzaService();
        OrdersService orderService = new DatabaseOrdersService();

        PizzeriaApplication app = new PizzeriaApplication(orderService, pizzaService);
        app.run();


    }
}