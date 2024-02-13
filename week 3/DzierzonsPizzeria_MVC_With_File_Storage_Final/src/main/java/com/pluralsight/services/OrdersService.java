package com.pluralsight.services;

import com.pluralsight.models.Order;

import java.io.*;
import java.util.Scanner;

public class OrdersService
{
    private static final String FILE_PATH = "data/orders.csv";

    public OrdersService()
    {
        Order.currentOrderId = getLastOrderNumber() + 1;

    }

    private int getLastOrderNumber()
    {
        File ordersFile = new File(FILE_PATH);
        int orderId = 1001;

        try(Scanner fileScanner = new Scanner(ordersFile))
        {
            fileScanner.nextLine();
            while (fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] columns = line.split(",");
                orderId = Integer.parseInt(columns[1]);
            }
        }
        catch(IOException ex)
        {
        }

        return orderId;
    }

    // add a new order
    // add a new line at the end of the file
    // open file to append
    public void addOrder(Order order)
    {
        // 1) open the file for writing (append true)
        try(FileWriter fileWriter = new FileWriter(FILE_PATH,true))
        {
            // feels like System.out
            PrintWriter orderWriter = new PrintWriter(fileWriter);
            orderWriter.println(order.toString());
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
