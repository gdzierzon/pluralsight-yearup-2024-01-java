package com.pluralsight.services;

import com.pluralsight.models.Car;
import com.pluralsight.models.Dealer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService
{
    private final String CAR_FILE_PATH = "data/vehicles.csv";
    private List<Car> cars;

    public CarService()
    {
        loadCars();
    }

    private void loadCars()
    {
        cars = new ArrayList<>();
        File file = new File(CAR_FILE_PATH);

        try(Scanner scanner = new Scanner(file))
        {
            scanner.nextLine();

            while(scanner.hasNext())
            {
                String line = scanner.nextLine();;
                String[] columns = line.split(",");

                int vin = Integer.parseInt(columns[0]);
                int dealerId =Integer.parseInt(columns[1]);
                int year = Integer.parseInt(columns[2]);
                String make = columns[3];
                String model = columns[4];
                String type = columns[5];
                String color = columns[6];
                int miles = Integer.parseInt(columns[7]);
                int price = Integer.parseInt(columns[8]);

                Car car = new Car(vin, dealerId, year, make, model, type, color, miles, price);

                cars.add(car);
            }
        }
        catch (FileNotFoundException e)
        {
        }
    }

    public List<Car> getAllCars(int dealerId)
    {
        List<Car> filteredCars = new ArrayList<>();

        for(Car car: cars)
        {
            if(car.getDealerId() == dealerId)
            {
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }

    public List<Car> searchByPrice(int dealerId, int minPrice, int maxPrice)
    {
        List<Car> filteredCars = new ArrayList<>();

        for(Car car: cars)
        {
            if(car.getDealerId() == dealerId
                && car.getPrice() >= minPrice
                && car.getPrice() <= maxPrice
            )
            {
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }
}
