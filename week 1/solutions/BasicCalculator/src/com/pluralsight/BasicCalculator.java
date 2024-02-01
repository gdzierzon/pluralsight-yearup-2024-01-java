package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        double operand1;
        double operand2;
        String choice;
        String operation;
        double answer;

        System.out.print("Enter the first number: ");
        operand1 = userInput.nextDouble();
        userInput.nextLine();

        System.out.print("Enter the second number: ");
        operand2 = userInput.nextDouble();
        userInput.nextLine();

        System.out.println("Possible calculations:");
        System.out.println("  (A)dd");
        System.out.println("  (S)ubtract");
        System.out.println("  (M)ultiply");
        System.out.println("  (D)ivide");
        System.out.print("Please select an option: ");
        choice = userInput.nextLine();

        switch(choice.toLowerCase())
        {
            case "a":
                answer = operand1 + operand2;
                operation = " + ";
                break;
            case "s":
                answer = operand1 - operand2;
                operation = " - ";
                break;
            case "m":
                answer = operand1 * operand2;
                operation = " * ";
                break;
            case "d":
            default:
                answer = operand1 / operand2;
                operation = " / ";
                break;
        }

        System.out.println(operand1 + operation + operand2 + " = " + answer);
    }
}
