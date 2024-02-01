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

        System.out.print("What is your first name? ");
        firstName = userInput.nextLine().strip();
        System.out.print("What is your middle name? ");
        middleName = userInput.nextLine();
        System.out.print("What is your last name? ");
        lastName = userInput.nextLine();
        System.out.print("What is your suffix? ");
        suffix = userInput.nextLine();

        Person person = new Person(firstName, middleName, lastName, suffix);

//        person.setFirstName(firstName);
//        person.setMiddleName(middleName);
//        person.setLastName(lastName);
//        person.setSuffix(suffix);

        System.out.println();
        System.out.println("Welcome " + person.getFullName());
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

        Person person = new Person(fullName);

        System.out.println("First Name:   " + person.getFirstName());
        System.out.println("Middle Name:  " + person.getMiddleName());
        System.out.println("Last Name:    " + person.getLastName());
        System.out.println("Suffix:       " + person.getSuffix());
    }
}
