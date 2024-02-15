package com.pluralsight.models;

import java.util.ArrayList;

public abstract class Order
{

    private int orderId;
    private String name;
    private String progress;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Order(String name)
    {
        orderId = 0;
        this.name = name;
        progress = "ordered";
    }

    public Order(int orderId, String name, String progress)
    {
        this.orderId = orderId;
        this.name = name;
        this.progress = progress;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getProgress()
    {
        return progress;
    }

    public void setProgress(String progress)
    {
        this.progress = progress;
    }

    public ArrayList<Pizza> getPizzas()
    {
        return pizzas;
    }

    public double getTotal()
    {
        double price = 0;

        for(Pizza pizza : pizzas)
        {
            price += pizza.getTotalPrice();
        }

        return price;
    }

    public void addPizza(Pizza pizza)
    {
        pizzas.add(pizza);
    }

    public String getType()
    {
        return (this instanceof DeliveryOrder) ? "delivery" : "dinein";
    }

    @Override
    public String toString()
    {
        return String.format("%s,%s,%s", orderId, name, progress);
    }
}
