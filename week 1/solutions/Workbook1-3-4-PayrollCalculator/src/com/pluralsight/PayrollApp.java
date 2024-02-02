package com.pluralsight;

import java.util.Scanner;

public class PayrollApp
{
    public static void main(String[] args)
    {
        // declare variables
        Scanner userInput = new Scanner(System.in);

        String name;
        double hours;
        double payRate;
        double grossPay;

        // get user input
        System.out.println();
        System.out.println("Payroll Calculator");
        System.out.println();

        System.out.print("Enter your name: ");
        name = userInput.nextLine().strip();

        System.out.print("Enter the hours worked: ");
        hours = userInput.nextDouble();
        userInput.nextLine();

        System.out.print("Enter your pay rate: ");
        payRate = userInput.nextDouble();
        userInput.nextLine();

        // calculate gross pay
        grossPay = hours * payRate;

        System.out.println();
        System.out.println("Name:         " + name);
        System.out.println("Pay Rate:     " + payRate);
        System.out.println("Hours Worked: " + hours);
        System.out.println("-----------------------");
        System.out.printf( "Total Pay:    $ %.2f",grossPay);
        System.out.println();

    }
}
