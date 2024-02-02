package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderApp
{
    public static void main(String[] args)
    {
        String fileName = "files/hansel_and_gretel.txt";
        // create a file object -> this will allow us to open the file
        File file = new File(fileName);

        // a Scanner opens the file and loads it into a stream
        try(Scanner fileScanner = new Scanner(file))
        {
            // keep reading the steam as long as there are more lines
            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();

                System.out.println(line);
            }
        }
        catch (Exception e)
        {
            System.out.println("There was an error reading the file.");
        }
    }
}
