package com.pluralsight.models.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    protected List<Card> cards;

    public Deck()
    {
        cards = new ArrayList<>();
    }

    public Deck(List<Card> cards)
    {
        this.cards = cards;
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public int getNumberOfCard()
    {
        return cards.size();
    }

    public Card getNextCard()
    {
        Card card = null;

        if(cards.size() > 0)
        {
            card = cards.get(0);
            cards.remove(0);
        }

        return card;
    }

    public void cut()
    {
        int count = (int)(getNumberOfCard() * Math.random());
        for (int i = 0; i < count; i++)
        {
            Card card = getNextCard();
            cards.add(card);
        }

    }
    
}
