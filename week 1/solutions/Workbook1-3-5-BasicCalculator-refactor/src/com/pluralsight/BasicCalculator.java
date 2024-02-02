package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {

        double operand1;
        double operand2;
        String choice;
        char operation;
        double answer;

        System.out.println();
        System.out.println("Basic Calculator");
        System.out.println();

        // get input
        operand1 = Double.parseDouble(getInput("Enter the first number: "));
        operand2 = Double.parseDouble(getInput("Enter the second number: "));
        displayOptions();
        choice = getInput("Please select an option: ");

        // calculate
        operation = getOperation(choice);
        answer = calculateAnswser(operand1, operand2, operation);

        // display output
        System.out.println();
        System.out.printf("%.2f %c %.2f = %.2f", operand1, operation, operand2, answer);
    }

    public static String getInput(String message)
    {
        System.out.print(message);
        return userInput.nextLine().strip();
    }

    public static void displayOptions()
    {
        System.out.println("----------------------");
        System.out.println("Possible calculations:");
        System.out.println("  (A)dd");
        System.out.println("  (S)ubtract");
        System.out.println("  (M)ultiply");
        System.out.println("  (D)ivide");
    }

    public static char getOperation(String choice)
    {
        switch(choice.toLowerCase())
        {
            case "a":
                return '+';
            case "s":
                return '-';
            case "m":
                return '*';
            case "d":
            default:
                return '/';
        }
    }

    public static double calculateAnswser(double operand1, double operand2, char operation)
    {
        switch(operation)
        {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
            default:
                return operand1 / operand2;
        }
    }
}
