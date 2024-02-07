package com.pluralsight.games;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame
{
    Scanner userInput = new Scanner(System.in);

    private ArrayList<Hand> players = new ArrayList<>();
    private Deck deck;

    public void run()
    {
        // main menu - home screen
        System.out.println();
        System.out.println("Welcome to Black Jack");

        while(true)
        {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1) Play a new game");
            System.out.println("2) Quit");
            System.out.println();
            System.out.print("Please select an option: ");
            int choice = userInput.nextInt();
            userInput.nextLine();

            if(choice == 1)
            {
                startGame();
            }
            else if(choice == 2)
            {
                // breaks out of the while loop
                // and ends the program
                break;
            }
            else
            {
                System.out.println("That choice is invalid.");
            }
        }

        System.out.println();
        System.out.println("Thanks for playing. Come again");

    }

    public void startGame()
    {
        // this function is the game manager;
        deck = new Deck();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();


        // start by adding a few players
        Hand player1 = createPlayer();
        players.add(player1);
        Hand player2 = createPlayer();
        players.add(player2);


        // deal 2 cards to each player
        dealRound();
        dealRound();

        // display each players hand
        for(Hand player: players)
        {
            showHand(player);
        }


        // loop and determine who won

        // display the winner
        System.out.println();
        System.out.println("Display who the winner is");
        System.out.println();
    }

    // the add player screen
    private Hand createPlayer()
    {
        System.out.print("Please enter a player name: ");
        String name = userInput.nextLine();
        // get the players name

        return new Hand(name);
    }

    private void dealRound()
    {
        // give each player 1 card
        for(Hand player : players)
        {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the player
            player.deal(card);
        }
    }

    private void showHand(Hand player)
    {
        // logic to show the hand
        System.out.println(player.getPlayerName() + " hand value");
    }
}
