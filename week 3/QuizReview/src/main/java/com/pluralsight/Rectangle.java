package com.pluralsight;

public class Rectangle extends Shape
{
    protected double width;
    protected double length;

    public Rectangle(int x, int y, double width, double length)
    {
        super(x, y);

        this.width = width;
        this.length = length;
    }

    public double getArea()
    {
        return length * width;
    }
}
