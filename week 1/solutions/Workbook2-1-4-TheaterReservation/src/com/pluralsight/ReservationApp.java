package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReservationApp
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String name;
        LocalDate reservationDate;
        int numberOfTickets;
        String[] names;
        String ticketText;

        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println("Theater Reservation");
        System.out.println("-".repeat(40));
        System.out.println();

        // get input
        name = getInput("Please enter your name: ");
        reservationDate = getInputDate("What date will you be coming (mm/dd/yyyy)? ");
        numberOfTickets = getInputInt("How many tickets would you like? ");

        // calculate
        names = name.split(" ");
        ticketText = numberOfTickets > 1 ? "ticktes" : "ticket";

        // Display message
        System.out.println();
        System.out.printf("%d %s reserved for %s under %s, %s", numberOfTickets, ticketText, reservationDate.toString(), names[1], names[0]);
    }

    public static String getInput(String message)
    {
        System.out.print(message);
        return userInput.nextLine().strip();
    }

    public static int getInputInt(String message)
    {
        return Integer.parseInt(getInput(message));
    }

    public static LocalDate getInputDate(String message)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(getInput(message), formatter);
    }
}
