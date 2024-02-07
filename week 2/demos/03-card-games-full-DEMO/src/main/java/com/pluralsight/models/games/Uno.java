package com.pluralsight.models.games;

import com.pluralsight.models.cards.Card;
import com.pluralsight.models.cards.Deck;
import com.pluralsight.models.hands.Hand;
import com.pluralsight.models.players.Player;

public class Uno extends ReversibleGame
{
    public Uno(Deck deck)
    {
        super(deck);
    }

    @Override public void dealPlayersIn()
    {
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < players.size(); j++)
            {
                Player player = getNextPlayer();
                Card card = deck.getNextCard();

                player.deal(card);
            }
        }

    }

    @Override
    public void endGame()
    {
        winner = players.peek();
        for(Player player : players)
        {
            Hand hand = player.showHand();
            //lowest score wins
            if(hand.getValue() < winner.getHandValue())
            {
                winner = player;
            }
        }
    }

    public void play(){}
}
