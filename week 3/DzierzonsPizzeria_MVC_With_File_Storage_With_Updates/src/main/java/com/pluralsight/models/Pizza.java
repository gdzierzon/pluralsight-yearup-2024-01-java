package com.pluralsight.models;

import java.util.ArrayList;

public class Pizza
{
    private int pizzaId;
    private int orderId;
    private String size;
    private String sauce;
    private String cheese;
    private ArrayList<String> toppings;

    public Pizza()
    {
        size = "Small";
        sauce = "Tomato";
        cheese = "Mozzarella";
        toppings = new ArrayList<>();
    }

    public Pizza(int pizzaId, int orderId, String size, String sauce, String cheese)
    {
        this.pizzaId = pizzaId;
        this.orderId = orderId;
        this.size = size;
        this.sauce = sauce;
        this.cheese = cheese;
        toppings = new ArrayList<>();
    }

    public int getPizzaId()
    {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId)
    {
        this.pizzaId = pizzaId;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        if(size.equalsIgnoreCase("s")) this.size = "Small";
        else if(size.equalsIgnoreCase("m")) this.size = "Medium";
        else if(size.equalsIgnoreCase("l")) this.size = "Large";
        else this.size = size;
    }

    public String getSauce()
    {
        return sauce;
    }

    public void setSauce(String sauce)
    {
        if(sauce.equalsIgnoreCase("t")) this.sauce = "Tomato";
        else if(sauce.equalsIgnoreCase("a")) this.sauce = "Alfredo";
        else if(sauce.equalsIgnoreCase("b")) this.sauce = "BBQ";
        else this.sauce = sauce;

    }

    public String getCheese()
    {
        return cheese;
    }

    public void setCheese(String cheese)
    {
        if(cheese.equalsIgnoreCase("m")) this.cheese = "Mozzarella";
        else if(cheese.equalsIgnoreCase("p")) this.cheese = "Provolone";
        else if(cheese.equalsIgnoreCase("a")) this.cheese = "American";
        else if(cheese.equalsIgnoreCase("c")) this.cheese = "Cheddar";
        else this.cheese = cheese;
    }

    public ArrayList<String> getToppings()
    {
        return toppings;
    }

    public void clearToppings()
    {
        toppings.clear();
    }

    public double getBasePrice()
    {
        // default price is for small
        double basePrice = 5.99;

        if(size.equalsIgnoreCase("Medium"))
        {
            basePrice = 8.99;
        }
        else if(size.equalsIgnoreCase("Large"))
        {
            basePrice = 11.99;
        }

        return basePrice;
    }

    public double getTotalPrice()
    {
        return getBasePrice() + (toppings.size() * 1.5);
    }

    public void addTopping(String topping)
    {
        toppings.add(topping);
    }

    @Override
    public String toString()
    {
        String formattedToppings = String.join("|", toppings);
        return String.format("%s,%s,%s,%s,%s,%s",pizzaId, orderId, size, sauce, cheese, formattedToppings);
    }
}
