package com.pluralsight;

import java.util.Scanner;

public class FullNameParserApp
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";
        String fullName;

        // get input
        System.out.print("Enter your full name: ");
        fullName = userInput.nextLine().strip();

        // parse name
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

        // output
        System.out.println("First Name:   " + firstName);
        System.out.println("Middle Name:  " + middleName);
        System.out.println("Last Name:    " + lastName);
        System.out.println("Suffix:       " + suffix);
    }
}
