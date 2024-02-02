package com.pluralsight;

import java.util.Scanner;

public class HighScoreApp
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter game details: ");
        String input = userInput.nextLine().strip();

        String[] parts = input.split("[:|]");
        String team1 = parts[0];
        String team2 = parts[1];
        int score1 = Integer.parseInt(parts[2]);
        int score2 = Integer.parseInt(parts[3]);

        System.out.println();
        String winner = score1 > score2 ? team1 : team2;

        System.out.println("The winner is " + winner);
    }
}
