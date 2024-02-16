package com.pluralsight.services;

import com.pluralsight.models.Order;

import java.util.ArrayList;

// think of an interface as a contract
public interface OrdersService
{
    void addOrder(Order order);
    ArrayList<Order> searchOrders(String status);
    Order getByOrderId(int orderId);
    void updateOrder(int orderId, Order order);
    void deleteOrder(int orderId);
}
