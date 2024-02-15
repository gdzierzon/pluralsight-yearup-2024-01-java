package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest
{

    @Test
    public void getTotal_ShouldReturn_2998_For2Large2ToppingPizzas()
    {
        // arrange
        Order order = new Order("John Doe");
        Pizza pizza1 = new Pizza();
        pizza1.setSize("l");
        pizza1.addTopping("Ham");
        pizza1.addTopping("Pineapple");
        order.addPizza(pizza1);
        Pizza pizza2 = new Pizza();
        pizza2.setSize("l");
        pizza2.addTopping("Chicken");
        pizza2.addTopping("Artichoke");
        order.addPizza(pizza2);
        double expected = 29.98;

        // act
        double actual = order.getTotal();

        // assert
        assertEquals(expected, actual, "because I added 2 large 2 topping pizzas to the order.");
    }

}