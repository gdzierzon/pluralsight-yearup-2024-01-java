package com.pluralsight;

import java.util.Scanner;

public class WorkingWithClasses
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("What would you like to do");
        System.out.println("  1) Enter each name individually");
        System.out.println("  2) Enter my full name");
        System.out.print(  "Please make your selection: ");
        int option = userInput.nextInt();
        userInput.nextLine();

        switch (option)
        {
            case 1:
                buildName();
                break;
            case 2:
                parseName();
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
    }

    public static void buildName()
    {
        String firstName;
        String middleName;
        String lastName;
        String suffix;
        String fullName;

        Person person;

        System.out.print("What is your first name? ");
        firstName = userInput.nextLine().strip();
        System.out.print("What is your middle name? ");
        middleName = userInput.nextLine();
        System.out.print("What is your last name? ");
        lastName = userInput.nextLine();
        System.out.print("What is your suffix? ");
        suffix = userInput.nextLine();

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

    public static void parseName()
    {
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";
        String fullName;

        System.out.print("Enter your full name: ");
        fullName = userInput.nextLine().strip();

        // check for suffix and remove it
        int commaIndex = fullName.indexOf(",");
        if(commaIndex >= 0)
        {
            suffix = fullName.substring(commaIndex + 2);
            fullName = fullName.substring(0, commaIndex);
        }

        String[] nameParts = fullName.split(" ");
        firstName = nameParts[0];
        if(nameParts.length > 2)
        {
            middleName = nameParts[1];
            lastName = nameParts[2];
        }
        else
        {
            lastName = nameParts[1];
        }

        System.out.println("First Name:   " + firstName);
        System.out.println("Middle Name:  " + middleName);
        System.out.println("Last Name:    " + lastName);
        System.out.println("Suffix:       " + suffix);
    }
}
