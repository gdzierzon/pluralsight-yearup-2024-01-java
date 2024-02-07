package com.pluralsight;

public class Car
{
    // private variables
    private String make;
    private String model;
    private double price;
    private String color;
    private String type;

    // constructor
    public Car(String make, String model, double price, String color, String type)
    {
        this.make = make;
        this.model = model;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    // getters/setters
    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    // other functions go here
    public void increasePrice(double percent)
    {
        price += price * percent;
    }
}
