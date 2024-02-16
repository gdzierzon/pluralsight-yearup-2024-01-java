package com.pluralsight.services;

import com.pluralsight.models.Car;
import com.pluralsight.models.Dealer;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarService
{
    DataSource dataSource;

    public CarService()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/dealership";
        String userName = "root";
        String password = "P@ssw0rd";
        dataSource = new BasicDataSource()
        {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};
    }

    public List<Car> getAllCars(int dealerId)
    {
        List<Car> cars = new ArrayList<>();

        String sql = "SELECT vin " +
                "   , dealer_id AS dealerId " +
                "   , year" +
                "   , make" +
                "   , model " +
                "   , type " +
                "   , color " +
                "   , miles " +
                "   , price " +
                " FROM vehicles " +
                " WHERE dealer_id = ?; ";

        try(Connection connection = dataSource.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dealerId);

            ResultSet rows = statement.executeQuery();
            while(rows.next())
            {
                Car car = new Car(rows.getInt("vin")
                        , rows.getInt("dealerId")
                        , rows.getInt("year")
                        , rows.getString("make")
                        , rows.getString("model")
                        , rows.getString("type")
                        , rows.getString("color")
                        , rows.getInt("miles")
                        , rows.getDouble("price")
                );

                cars.add(car);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return cars;
    }

    public List<Car> searchByPrice(int dealerId, int minPrice, int maxPrice)
    {
        List<Car> cars = new ArrayList<>();

        String sql = "SELECT vin " +
                "   , dealer_id AS dealerId " +
                "   , year" +
                "   , make" +
                "   , model " +
                "   , type " +
                "   , color " +
                "   , miles " +
                "   , price " +
                " FROM vehicles " +
                " WHERE dealer_id = ? " +
                "   AND price BETWEEN ? AND ? ; ";

        try(Connection connection = dataSource.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dealerId);
            statement.setInt(2, minPrice);
            statement.setInt(3, maxPrice);

            ResultSet rows = statement.executeQuery();
            while(rows.next())
            {
                Car car = new Car(rows.getInt("vin")
                        , rows.getInt("dealerId")
                        , rows.getInt("year")
                        , rows.getString("make")
                        , rows.getString("model")
                        , rows.getString("type")
                        , rows.getString("color")
                        , rows.getInt("miles")
                        , rows.getDouble("price")
                );

                cars.add(car);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return cars;
    }
}
