package com.pluralsight;

import java.util.ArrayList;

public class CarsDemo
{
    public static void main(String[] args)
    {

        // The VERY OLD way of doing things (ANCIENT)
        ArrayList<String> makes = new ArrayList<>();
        ArrayList<String> models = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> types = new ArrayList<>();

        makes.add("Ford");
        models.add("Mustang");
        prices.add(35000.00);
        colors.add("Red");
        types.add("Muscle Car");

        makes.add("Ford");
        models.add("F-150");
        prices.add(55000.00);
        colors.add("White");
        types.add("Truck");

        makes.add("Chevrolet");
        models.add("Silverado");
        prices.add(60000.00);
        colors.add("White");
        types.add("Truck");

        // The OOP way of doing things
        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("Ford", "Mustang", 35000.00, "Red", "Muscle Car"));
        cars.add(new Car("Ford", "F150", 55000.00, "White", "Truck"));
        cars.add(new Car("Chevrolet", "Silverado", 60000.00, "White", "Truck"));

        System.out.println();
        for(Car car : cars)
        {
            System.out.printf("%s %s: $ %.2f \n", car.getMake(), car.getModel(), car.getPrice());
        }

        for(Car car : cars)
        {
            car.increasePrice(.2);
        }


        System.out.println();
        System.out.println("Cars after price increase");
        System.out.println("--------------------------");
        for(Car car : cars)
        {
            System.out.printf("%s %s: $ %.2f \n", car.getMake(), car.getModel(), car.getPrice());
        }
    }
}
