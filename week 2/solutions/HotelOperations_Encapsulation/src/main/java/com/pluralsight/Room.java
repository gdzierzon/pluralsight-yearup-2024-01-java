package com.pluralsight;

public class Room
{
    // create private variables
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    // create a constructor that takes all variables

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty)
    {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }


    // create getters here (this class should not have any setters)

    public int getNumberOfBeds()
    {
        return numberOfBeds;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean isOccupied()
    {
        return isOccupied;
    }

    public boolean isDirty()
    {
        return isDirty;
    }

    public boolean isAvailable()
    {
        return !isOccupied && !isDirty;
    }

    public void checkIn()
    {
        isOccupied = true;
        isDirty = true;
    }

    public void checkOut()
    {
        isOccupied = false;
    }

    public void cleanRoom()
    {
        isDirty = false;
    }

}
