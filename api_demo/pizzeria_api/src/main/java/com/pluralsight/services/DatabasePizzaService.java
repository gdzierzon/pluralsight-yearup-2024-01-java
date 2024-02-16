package com.pluralsight.services;

import com.pluralsight.models.Pizza;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class DatabasePizzaService implements PizzaService
{
    private DataSource dataSource;

    @Autowired
    public DatabasePizzaService(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }


    @Override public void addPizza(int orderId, Pizza pizza)
    {
        pizza.setOrderId(orderId);

        try(Connection connection = dataSource.getConnection())
        {
            // first insert the pizza
            String sql = "INSERT INTO pizzas (order_id, pizza_size, sauce, cheese) " +
                        " VALUES (?,?,?,?); ";
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, orderId);
            statement.setString(2, pizza.getSize());
            statement.setString(3, pizza.getSauce());
            statement.setString(4, pizza.getCheese());

            statement.executeUpdate();

            // get the new pizza_id (autonumber)
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            int pizzaId = key.getInt(1);
            pizza.setPizzaId(pizzaId);

            // now insert all the toppings
            saveToppings(pizza);
        }
        catch (SQLException e)
        {
        }
    }

    @Override public Pizza getPizzaById(int pizzaId)
    {
        Pizza pizza = null;
        try(Connection connection = dataSource.getConnection())
        {
            String sql = "SELECT pizza_id " +
                        "   , order_id " +
                        "   , pizza_size " +
                        "   , sauce " +
                        "   , cheese " +
                        " FROM pizzas " +
                        " WHERE pizza_id = ?; ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pizzaId);

            ResultSet rows = statement.executeQuery();

            if(rows.next())
            {
                pizza = new Pizza(rows.getInt("pizza_id"),
                        rows.getInt("order_id"),
                        rows.getString("pizza_size"),
                        rows.getString("sauce"),
                        rows.getString("cheese")
                );

                getToppings(pizza);
            }
        }
        catch (SQLException e)
        {
        }


        return pizza;
    }

    @Override public ArrayList<Pizza> findByOrderId(int orderId)
    {
        ArrayList<Pizza> pizzas = new ArrayList<>();

        try(Connection connection = dataSource.getConnection())
        {
            String sql = "SELECT pizza_id " +
                    "   , order_id " +
                    "   , pizza_size " +
                    "   , sauce " +
                    "   , cheese " +
                    " FROM pizzas " +
                    " WHERE order_id = ?; ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);

            ResultSet rows = statement.executeQuery();

            while(rows.next())
            {
                Pizza pizza = new Pizza(rows.getInt("pizza_id"),
                        rows.getInt("order_id"),
                        rows.getString("pizza_size"),
                        rows.getString("sauce"),
                        rows.getString("cheese")
                );

                getToppings(pizza);

                pizzas.add(pizza);
            }
        }
        catch (SQLException e)
        {
        }

        return pizzas;
    }

    @Override public void updatePizza(int pizzaId, Pizza pizza)
    {
        try(Connection connection = dataSource.getConnection())
        {
            String sql = "UPDATE pizzas " +
                        " SET pizza_size = ?, " +
                        "   sauce = ?, " +
                        "   cheese = ?" +
                        " WHERE pizza_id = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,pizza.getSize());
            statement.setString(2,pizza.getSauce());
            statement.setString(3,pizza.getCheese());
            statement.setInt(4, pizzaId);

            // this does not affect toppings yet
            statement.executeUpdate();

            // delete the toppings that are currently in the database
            clearToppings(pizzaId);
            // re-add all updated toppings
            saveToppings(pizza);
        }
        catch (SQLException e)
        {
        }
    }

    @Override public void deletePizza(int pizzaId)
    {
        try(Connection connection = dataSource.getConnection())
        {
            // we need to delete all toppings first
            clearToppings(pizzaId);

            String sql = "DELETE FROM pizzas WHERE pizza_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pizzaId);
            // then we can delete the pizza
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }
    }

    @Override public void deleteByOrderId(int orderId)
    {
        try(Connection connection = dataSource.getConnection())
        {
            // delete all toppings first
            String sql = "DELETE FROM pizza_toppings " +
                        " WHERE pizza_id IN (" +
                        "   SELECT pizza_id FROM pizzas WHERE order_id = ? " +
                        " ); ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            statement.executeUpdate();

            // then delete the pizzas
            sql = "DELETE FROM pizzas where order_id = ?; ";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }
    }


    private void getToppings(Pizza pizza)
    {
        try(Connection connection = dataSource.getConnection())
        {
            String sql = "SELECT topping " +
                    " FROM pizza_toppings " +
                    " WHERE pizza_id = ?; ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pizza.getPizzaId());

            ResultSet rows = statement.executeQuery();
            while(rows.next())
            {
                pizza.addTopping(rows.getString("topping"));
            }
        }
        catch (SQLException e)
        {
        }

    }
    private void saveToppings(Pizza pizza)
    {
        try(Connection connection = dataSource.getConnection())
        {
            String toppingSql = "INSERT INTO pizza_toppings (pizza_id, topping) " +
                                "VALUES (?,?); ";

            for(String topping : pizza.getToppings())
            {
                PreparedStatement statement = connection.prepareStatement(toppingSql);
                statement.setInt(1, pizza.getPizzaId());
                statement.setString(2, topping);

                statement.executeUpdate();
            }
        }
        catch (SQLException e)
        {
        }

    }

    private void clearToppings(int pizzaId)
    {
        try(Connection connection = dataSource.getConnection())
        {
            String toppingSql = "DELETE FROM pizza_toppings WHERE pizza_id = ? ";

            PreparedStatement statement = connection.prepareStatement(toppingSql);
            statement.setInt(1, pizzaId);

            statement.executeUpdate();

        }
        catch (SQLException e)
        {
        }
    }
}
