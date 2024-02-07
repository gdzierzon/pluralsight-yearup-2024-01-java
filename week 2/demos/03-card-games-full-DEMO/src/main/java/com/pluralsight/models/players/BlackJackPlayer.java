package com.pluralsight.models.players;

import com.pluralsight.models.hands.BlackJackHand;

public class BlackJackPlayer extends Player
{
    private boolean stayed = false;

    public BlackJackPlayer(String name)
    {
        super(name, new BlackJackHand());
    }

    public boolean hasStayed()
    {
        return stayed;
    }

    public void stay()
    {
        stayed = true;
    }
}
