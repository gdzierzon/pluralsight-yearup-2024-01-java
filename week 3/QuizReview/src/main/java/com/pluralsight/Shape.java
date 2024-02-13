package com.pluralsight;

// an abstract class DOES NOT have enough information to be useful
public abstract class Shape // extends Object is implied
{
    private int x;
    private int y;

    public Shape(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    // I don't have enough information to know how to calculate the area
    // so I mark it as abstract
    // This is a contract that says any child class MUST override the getArea function
    public abstract double getArea();
}
