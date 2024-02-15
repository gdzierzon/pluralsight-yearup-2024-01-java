package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

public class DatabaseDemo
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter a country code: ");
        String country = userInput.nextLine().strip();

        displayCities(country);
    }

    public static void displayCities(String countrySearch)
    {
        // 1. define our datasource
        // a web url "https://www.myapi.com/cities"
        String databaseUrl = "jdbc:mysql://localhost:3306/world";
        String userName = "root";
        String password = "P@ssw0rd";

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        // 2. open a connection to the datasource (like opening a file stream)
        // executing a select statement
        try(Connection connection = dataSource.getConnection())
        {
            String sql = "SELECT id " +
                        "   , name " +
                        "   , countrycode as country " +
                        "   , district as state " +
                        "   , population " +
                        " FROM city " +
                        " WHERE CountryCode = ?; ";


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, countrySearch);

            // 3a. execute your query
            ResultSet rows = statement.executeQuery();


            // 3b. loop through all rows that are returned
            while(rows.next())
            {
                int id = rows.getInt("id");
                String name = rows.getString("name");
                String country = rows.getString("country");
                String state = rows.getString("state");
                int population = rows.getInt("population");

                System.out.printf("%-5d %-30s %-5s %-20s %d \n", id, name, country, state, population);
            }

            // the next line closes the connection
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }
}
