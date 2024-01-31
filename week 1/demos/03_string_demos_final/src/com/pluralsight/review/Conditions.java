package com.pluralsight.review;

import java.util.Scanner;

public class Conditions
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String day;
        String diner;

        System.out.println();
        System.out.print("What day is it? ");
        day = userInput.nextLine();

        diner = whereToEatSwitch(day);
        System.out.println("You should eat at " + diner);

    }

    public static String whereToEatIf(String dayOfWeek)
    {
        if(dayOfWeek.equalsIgnoreCase("monday"))
        {
            return "Wendys";
        }
        else if(dayOfWeek.equalsIgnoreCase("tuesday"))
        {
            return "Costa Vida";
        }
        else
        {
            return "Home";
        }
    }

    public static String whereToEatSwitch(String dayOfWeek)
    {
        String location;
        switch(dayOfWeek.toLowerCase())
        {
            case "monday":
                location = "Wendys";
                break;
            case "tuesday":
            case "thursday":
                location = "Costa Vida";
                break;
            default:
                location = "Home";

        }

        return location;
    }
}
