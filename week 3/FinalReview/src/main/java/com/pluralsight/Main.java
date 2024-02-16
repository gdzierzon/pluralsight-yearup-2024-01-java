package com.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        String name = "Gregor";
        int age = 49;

        // the object car is an instance of the class Car
        Car car = new Car(1234, 2020, "Audi");

        age = age + 7;
        age += 7;
        age++;
        ++age;

        System.out.println(++age);
        System.out.println(age);
    }
}