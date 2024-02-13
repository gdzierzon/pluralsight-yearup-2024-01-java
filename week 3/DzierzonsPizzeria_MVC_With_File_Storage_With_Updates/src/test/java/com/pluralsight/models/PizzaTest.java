package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest
{
    @Test
    public void getSize_ShouldReturn_Medium_WhenSetTo_m()
    {
        // arrange
        Pizza pizza = new Pizza();
        String expected = "Medium";

        // act
        pizza.setSize("m");

        // assert
        String actual = pizza.getSize();
        assertEquals(expected, actual, "because the size was set to m and should display the full word Medium.");
    }

    @Test
    public void getTotalPrice_ShouldReturn_1199_ForLargeNoToppings()
    {
        // arrange
        Pizza pizza = new Pizza();
        pizza.setSize("l");
        double expected = 11.99;

        // act
        double actual = pizza.getTotalPrice();

        // assert
        assertEquals(expected,actual, "Because I set the size to l");
    }

}