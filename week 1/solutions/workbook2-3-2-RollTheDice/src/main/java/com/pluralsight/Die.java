package com.pluralsight;

public class Die
{
    private int value = 1;

    public int getValue()
    {
        return value;
    }

    public void roll()
    {
        value = 1 + (int)(Math.random() * 6);
    }
}
