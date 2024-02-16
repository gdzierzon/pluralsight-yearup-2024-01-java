package com.pluralsight.services;

import com.pluralsight.DealershipApplication;
import com.pluralsight.models.Dealer;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealerService
{
    DataSource dataSource;

    public DealerService()
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

    public List<Dealer> getAllDealers()
    {
        List<Dealer> dealers = new ArrayList<>();

        String sql = "SELECT dealer_id AS id " +
                "   , name" +
                "   , address " +
                "   , city " +
                "   , state " +
                "   , zip " +
                "   , phone " +
                " FROM dealers; ";

        try(Connection connection = dataSource.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rows = statement.executeQuery();
            while(rows.next())
            {
                Dealer dealer = new Dealer(rows.getInt("id")
                        , rows.getString("name")
                        , rows.getString("address")
                        , rows.getString("city")
                        , rows.getString("state")
                        , rows.getString("zip")
                        , rows.getString("phone")
                );

                dealers.add(dealer);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return dealers;
    }
}
