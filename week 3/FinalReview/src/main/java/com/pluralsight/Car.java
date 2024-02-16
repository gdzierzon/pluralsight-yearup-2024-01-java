package com.pluralsight;

// template
public class Car
{
    private int id;
    private int year;
    private String make;

    public Car(int id, int year, String make)
    {
        this.id = id;
        this.year = year;
        this.make = make;
    }

    public int getId()
    {
        return id;
    }

    public int getYear()
    {
        return year;
    }

    public String getMake()
    {
        return make;
    }
}
