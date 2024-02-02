package com.pluralsight;

import java.util.Scanner;

public class NameGeneratorApp
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String firstName;
        String middleName;
        String lastName;
        String suffix;
        String fullName;

        // user input
        System.out.print("What is your first name? ");
        firstName = userInput.nextLine().strip();
        System.out.print("What is your middle name? ");
        middleName = userInput.nextLine();
        System.out.print("What is your last name? ");
        lastName = userInput.nextLine();
        System.out.print("What is your suffix? ");
        suffix = userInput.nextLine();

        // create name
        // add first name to the full name
        fullName = firstName + " ";
        // add middle name if they have one
        if(!middleName.equals("")) {
            fullName += middleName + " ";
        }
        //add last name
        fullName += lastName;
        // add suffix if they have one
        if(!suffix.equals("")){
            fullName += ", " + suffix;
        }

        System.out.println();
        System.out.println("Welcome " + fullName);
    }

}
