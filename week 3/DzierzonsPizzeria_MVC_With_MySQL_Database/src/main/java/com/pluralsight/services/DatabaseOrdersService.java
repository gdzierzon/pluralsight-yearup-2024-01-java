package com.pluralsight.services;

import com.pluralsight.models.DeliveryOrder;
import com.pluralsight.models.DineInOrder;
import com.pluralsight.models.Order;
import com.pluralsight.models.Pizza;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseOrdersService implements OrdersService
{
    DataSource dataSource;
    PizzaService pizzaService = new DatabasePizzaService();

    public DatabaseOrdersService()
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

    @Override
    public void addOrder(Order order)
    {
        try(Connection connection = dataSource.getConnection())
        {
            String sql = "INSERT INTO orders (`name`, `progress`, `order_type`) " +
                        " VALUES (?,'ordered',?);";
            
            // include PreparedStatement.RETURN_GENERATED_KEYS only when inserting into
            // a table with an auto numbered field
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, order.getName());
            statement.setString(2, order.getType());

            // insert the order
            statement.executeUpdate();

            // get the auto number id of the new order
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            int newId = key.getInt(1);
            order.setOrderId(newId);

            if(order.getType().equalsIgnoreCase("delivery"))
            {
                insertDeliveryInfo((DeliveryOrder) order);
            }
            else
            {
                insertDineInInfo((DineInOrder) order);
            }


        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void insertDeliveryInfo(DeliveryOrder order)
    {
        String sql = "INSERT INTO delivery_orders(`order_id`,address, apartment, city, state, zip) " +
                    " VALUES (?,?,?,?,?,?)";

        try(Connection connection = dataSource.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getAddress());
            statement.setString(3, order.getApartment());
            statement.setString(4, order.getCity());
            statement.setString(5, order.getState());
            statement.setString(6, order.getZip());

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }
    }
    private void insertDineInInfo(DineInOrder order)
    {
        String sql = "INSERT INTO dine_in_orders(`order_id`, reservation_time, number_of_guests, table_number, server) " +
                " VALUES (?,?,?,?,?)";

        try(Connection connection = dataSource.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getReservationTime());
            statement.setInt(3, order.getNumberOfGuests());
            statement.setInt(4, order.getTable());
            statement.setString(5, order.getServer());

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }
    }

    @Override
    public Order getByOrderId(int orderId)
    {
        String sql = "SELECT o.order_id " +
                "    , o.name " +
                "    , o.progress " +
                "    , o.order_type " +
                "    , dio.reservation_time " +
                "    , dio.number_of_guests " +
                "    , dio.table_number " +
                "    , dio.server " +
                "    , del.address " +
                "    , del.apartment " +
                "    , del.city " +
                "    , del.state " +
                "    , del.zip " +
                "FROM orders AS o " +
                "LEFT JOIN dine_in_orders as dio " +
                "   ON o.order_id = dio.order_id " +
                "LEFT JOIN delivery_orders as del " +
                "   ON o.order_id = del.order_id " +
                "WHERE o.order_id = ?;";

        try(Connection connection = dataSource.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);

            ResultSet row = statement.executeQuery();
            row.next();

            Order order;
            if(row.getString("order_type").equalsIgnoreCase("dinein"))
            {
                order = new DineInOrder( row.getInt("order_id")
                            , row.getString("name")
                            , row.getString("progress")
                            , row.getString("reservation_time")
                            , row.getInt("number_of_guests")
                            , row.getInt("table_number")
                            , row.getString("server")
                        );
            }
            else
            {
                order = new DeliveryOrder(row.getInt("order_id")
                        , row.getString("name")
                        , row.getString("progress")
                        , row.getString("address")
                        , row.getString("apartment")
                        , row.getString("city")
                        , row.getString("state")
                        , row.getString("zip")
                );
            }

            // use the pizza service to get pizzas from the database
            ArrayList<Pizza> pizzas = pizzaService.findByOrderId(order.getOrderId());
            for(Pizza pizza: pizzas)
            {
                order.addPizza(pizza);
            }

            return order;
        }
        catch (SQLException e)
        {
        }
        return null;
    }

    @Override
    public void updateOrder(int orderId, Order order)
    {

        try(Connection connection = dataSource.getConnection())
        {
            String sql = "UPDATE orders " +
                    " SET progress = ? " +
                    " WHERE order_id = ?; " ;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, order.getProgress());
            statement.setInt(2, orderId);

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }
    }

    @Override
    public void deleteOrder(int orderId)
    {
        try(Connection connection = dataSource.getConnection())
        {
            // delete all pizzas
            pizzaService.deleteByOrderId(orderId);

            PreparedStatement statement;

            // delete delivery orders (if exists)
            statement = connection.prepareStatement("DELETE FROM delivery_orders WHERE order_id = ?;");
            statement.setInt(1, orderId);
            statement.executeUpdate();

            // delete dine in order (if exists)
            statement = connection.prepareStatement("DELETE FROM dine_in_orders WHERE order_id = ?;");
            statement.setInt(1, orderId);
            statement.executeUpdate();

            // finally delete the root order
            statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?;");
            statement.setInt(1, orderId);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
