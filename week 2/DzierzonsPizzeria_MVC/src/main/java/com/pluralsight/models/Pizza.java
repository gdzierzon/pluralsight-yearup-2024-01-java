package com.pluralsight.models;

import java.util.ArrayList;

public class Pizza
{
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

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = "Small";

        if(size.equalsIgnoreCase("m")) this.size = "Medium";
        else if(size.equalsIgnoreCase("l")) this.size = "Large";
    }

    public String getSauce()
    {
        return sauce;
    }

    public void setSauce(String sauce)
    {
        this.sauce = "Tomato";

        if(sauce.equalsIgnoreCase("a")) this.sauce = "Alfredo";
        else if(sauce.equalsIgnoreCase("b")) this.sauce = "BBQ";

    }

    public String getCheese()
    {
        return cheese;
    }

    public void setCheese(String cheese)
    {
        this.cheese = "Mozzarella";

        if(cheese.equalsIgnoreCase("p")) this.cheese = "Provolone";
        else if(cheese.equalsIgnoreCase("a")) this.cheese = "American";
        else if(cheese.equalsIgnoreCase("c")) this.cheese = "Cheddar";

    }

    public ArrayList<String> getToppings()
    {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings)
    {
        this.toppings = toppings;
    }

    public double getBasePrice()
    {
        double basePrice = 5.99;

        if(size.equalsIgnoreCase("m"))
        {
            basePrice = 8.99;
        }
        else if(size.equalsIgnoreCase("l"))
        {
            basePrice = 11.99;
        }

        return basePrice;
    }

    public double getTotalPrice()
    {
        return getBasePrice() + (toppings.size() * 1.5);
    }
}
