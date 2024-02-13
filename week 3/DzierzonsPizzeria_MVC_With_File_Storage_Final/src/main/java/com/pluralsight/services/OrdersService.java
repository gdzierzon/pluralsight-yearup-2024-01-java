package com.pluralsight.services;

import com.pluralsight.models.DeliveryOrder;
import com.pluralsight.models.DineInOrder;
import com.pluralsight.models.Order;
import com.pluralsight.models.Pizza;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class OrdersService
{
    private static final String FILE_PATH = "data/orders.csv";

    private HashMap<Integer, Order> orders;

    public OrdersService()
    {
        Order.currentOrderId = getLastOrderNumber() + 1;
        orders = loadOrders();
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
                orderId = Integer.parseInt(columns[0]);
            }
        }
        catch(IOException ex)
        {
        }

        return orderId;
    }

    private HashMap<Integer, Order> loadOrders()
    {
        HashMap<Integer, Order> orders = new HashMap<>();

        File file = new File(FILE_PATH);

        try(Scanner scanner = new Scanner(file))
        {
            scanner.nextLine()
            ;
            while(scanner.hasNext())
            {
                // get order details from each line in the file
                String orderLine = scanner.nextLine();
                String[] columns = orderLine.split(",");

                int orderId = Integer.parseInt(columns[0]);
                String type = columns[1];
                String name = columns[2];
                String progress = columns[3];

                // create the right kind of order based on type

                // add order to the list

            }
        }
        catch (IOException e)
        {
        }

        return orders;
    }

    private void saveChanges()
    {
        // overwrite the entire file
        try(FileWriter fileWriter = new FileWriter(FILE_PATH, false))
        {
            PrintWriter orderWriter = new PrintWriter(fileWriter);
            // write header line
            orderWriter.println("order id,type,customer name,progress");

            for(Order order : orders.values())
            {
                orderWriter.println(order.toString());
            }
        }
        catch (IOException ex)
        {

        }
    }

    // add a new order
    public void addOrder(Order order)
    {
        // this is actually where we should add the order ID

        // open the file for writing (append true)
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

    public Order getByOrderId(int orderId)
    {
        return orders.get(orderId);
    }

    public void updateOrder(int orderId, Order order)
    {
        Order currentOrder = orders.get(orderId);
        if(currentOrder != null)
        {
            currentOrder.setName(order.getName());
            currentOrder.setProgress(order.getProgress());

            if(order instanceof DeliveryOrder)
            {
                DeliveryOrder current = (DeliveryOrder) currentOrder;
                DeliveryOrder updated = (DeliveryOrder) order;
                current.setAddress(updated.getAddress());
                current.setApartment(updated.getApartment());
                current.setCity(updated.getCity());
                current.setState(updated.getState());
                current.setZip(updated.getZip());
            }
            else if(order instanceof DineInOrder)
            {
                DineInOrder current = (DineInOrder) currentOrder;
                DineInOrder updated = (DineInOrder) order;
                current.setReservationTime(updated.getReservationTime());
                current.setNumberOfGuests(updated.getNumberOfGuests());
                current.setTable(updated.getTable());
                current.setServer(updated.getServer());
            }
        }

        // overwrite the file with the changes
        saveChanges();
    }

    public void deleteOrder(int orderId)
    {
        orders.remove(orderId);

        // overwrite the file with the changes
        saveChanges();
    }
}
