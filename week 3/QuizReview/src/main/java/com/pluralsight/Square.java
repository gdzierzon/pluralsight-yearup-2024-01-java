package com.pluralsight;

public class Square extends Rectangle
{
    public Square(int x, int y, double edgeLength)
    {
        super(x, y, edgeLength, edgeLength);
    }

    public double getDoubleArea()
    {
        return width * length * 2;
    }
}
