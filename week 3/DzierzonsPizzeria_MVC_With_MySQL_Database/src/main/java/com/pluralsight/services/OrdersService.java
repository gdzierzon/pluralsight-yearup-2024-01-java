package com.pluralsight.services;

import com.pluralsight.models.Order;

// think of an interface as a contract
public interface OrdersService
{
    void addOrder(Order order);
    Order getByOrderId(int orderId);
    void updateOrder(int orderId, Order order);
    void deleteOrder(int orderId);
}
