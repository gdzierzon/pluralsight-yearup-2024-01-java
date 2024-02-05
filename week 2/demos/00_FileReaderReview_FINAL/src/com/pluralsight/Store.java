package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store
{
    public static void main(String[] args)
    {
        ArrayList<Product> myProducts = loadProducts();
    }

    public static ArrayList<Product> loadProducts()
    {
        ArrayList<Product> products = new ArrayList<>();

        // 1. define the source
        File productsFile = new File("files/products.csv");
        // 2. open the file
        try(Scanner fileScanner = new Scanner(productsFile))
        {
            // 3. read the file contents
            System.out.println(fileScanner.nextLine());

            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
//                System.out.println(line);

                // use the data in the line to create a new product
                String[] columns = line.split(",");
                String sku = columns[0];
                String name = columns[1];
                double price = Double.parseDouble(columns[2]);
                String department = columns[3];

                Product product = new Product(sku, name, price, department);
                products.add(product);
            }
        }
        catch(IOException ex)
        {
            System.out.println("There was an error loading the products.");
        }

        return products;
    }
}
