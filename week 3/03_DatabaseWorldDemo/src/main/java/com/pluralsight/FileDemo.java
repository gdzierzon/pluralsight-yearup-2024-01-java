package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDemo
{
    public static void main(String[] args)
    {
        readFile();
    }

    public static void readFile()
    {
        // 1. define the file source
        File file = new File("files/cities.csv");

        // 2. open the file stream
        try(Scanner fileScanner = new Scanner(file))
        {
            // skip the first line
            fileScanner.nextLine();

            // 3. loop through the lines in the file
            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                // split the lines into columns
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                String country = columns[2];
                String state = columns[3];
                int population = Integer.parseInt(columns[4]);

                System.out.printf("%-5d %-30s %-5s %-20s %d \n", id, name, country, state, population);
            }

            // fileScanner closes after this try block ends
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There was a problem: " + e.getMessage());
        }

    }

}