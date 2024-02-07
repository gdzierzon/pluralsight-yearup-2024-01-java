package com.pluralsight.models.games;

import com.pluralsight.models.hands.BlackJackHand;
import com.pluralsight.models.players.BlackJackPlayer;
import com.pluralsight.models.players.Player;
import com.pluralsight.models.cards.Card;
import com.pluralsight.models.cards.facecards.FaceCardDeck;

public class BlackJack extends CardGame
{
    public BlackJack(FaceCardDeck deck)
    {
        super(deck);

        deck.shuffle();
        deck.shuffle();

        deck.cut();
    }

    @Override
    public void dealPlayersIn()
    {
        for (int i = 0; i < 2; i++)
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
        winner = new BlackJackPlayer("");
        for(Player player : players)
        {
            BlackJackHand hand = (BlackJackHand) player.showHand();
            if(!hand.isBust() && hand.getValue() > winner.getHandValue())
            {
                winner = player;
            }
        }
    }

    // add this to BlackJack only because
    // that is what a deal is called
    public void hit(Player player)
    {
        deal(player);
    }

    public void stay(Player player)
    {
        ((BlackJackPlayer)player).stay();
    }


    public boolean allStayed()
    {
        for(Player player : players)
        {
            BlackJackPlayer blackJackPlayer = (BlackJackPlayer) player;
            if(!blackJackPlayer.hasStayed())
                return false; // at least one has not stayed
        }

        // if we get here, all have stayed
        return true;
    }

    public void play(){}
}
