package com.pluralsight.services;

import com.pluralsight.models.Pizza;

import java.util.ArrayList;

public interface PizzaService
{
    void addPizza(int orderId, Pizza pizza);
    Pizza getPizzaById(int pizzaId);
    ArrayList<Pizza> findByOrderId(int orderId);
    void updatePizza(int pizzaId, Pizza updatedPizza);
    void deletePizza(int pizzaId);
    void deleteByOrderId(int orderId);
}
