package com.pluralsight.ui;

import com.pluralsight.ui.enumerations.BlackJackPlay;
import com.pluralsight.ui.enumerations.GameOptions;

import java.util.Scanner;

public class UserInput 
{
    private final static Scanner scanner = new Scanner(System.in);

    public static GameOptions gameToPlay()
    {
        UserOutput.clear();
        UserOutput.printHeader("Welcome to Card Games Mania");
        while(true)
        {
            System.out.println();
            System.out.println("What game do you want to play?");
            System.out.println("[B] Black Jack");
            System.out.println("[U] Uno");
            System.out.println("[Q] Quit");
            System.out.println();

            System.out.print("Select an option: ");

            String input = scanner.nextLine()
                                  .trim()
                                  .toLowerCase();

            if ("b".equals(input))
            {
                return GameOptions.BlackJack;
            }
            else if ("u".equals(input))
            {
                return GameOptions.Uno;
            }
            else if ("q".equals(input))
            {
                return GameOptions.Quit;
            }
            else
            {
                System.out.println("You must select a valid option (B/U/Q)");
            }
        }
    }

    public static BlackJackPlay homeScreen()
    {
        UserOutput.clear();
        UserOutput.printHeader("Let's play some Black Jack!");
        while(true)
        {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("[P] Play");
            System.out.println("[B] Back");
            System.out.println();
            System.out.print("Select an option: ");

            String input = scanner.nextLine()
                                  .trim()
                                  .toLowerCase();

            if ("p".equals(input))
            {
                return BlackJackPlay.Play;
            }
            else if ("b".equals(input))
            {
                return BlackJackPlay.Quit;
            }
            else
            {
                System.out.println("You must select a valid option (P/B)");
            }
        }
    }
    
    public static BlackJackPlay hitOrStay()
    {
        while(true)
        {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("[H] Hit");
            System.out.println("[S] Stay");
            System.out.println();
            System.out.print("Select an option: ");

            String input = scanner.nextLine()
                                  .trim()
                                  .toLowerCase();

            if ("h".equals(input))
            {
                return BlackJackPlay.Hit;
            }
            else if ("s".equals(input))
            {
                return BlackJackPlay.Stay;
            }
            else
            {
                System.out.println("You must select a valid option (H/S)");
            }
        }

    }

    public static int numberOfPlayers()
    {
        System.out.println();
        System.out.print("How many players? ");

        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

	public static String getPlayerName()
	{
        System.out.println();
        System.out.print("Please enter your name: ");

        return scanner.nextLine();
	}

    public static void waitForInput()
    {
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
    }
}
