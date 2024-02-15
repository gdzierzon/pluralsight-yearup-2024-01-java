package com.pluralsight.services;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabasePizzaService
{
    BasicDataSource dataSource;
    public DatabasePizzaService()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/pizzaria";
        String userName = "root";
        String password = "P@ssw0rd";
        dataSource = new BasicDataSource()
        {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};
    }
}
