package com.pluralsight.models.cards;

public class Dealer
{
    private Deck deck;

    public Dealer(Deck deck)
    {
        this.deck = deck;
    }

    public void shuffle()
    {
        deck.shuffle();
    }

    public int countCards()
    {
        return deck.getNumberOfCard();
    }

    public Card deal()
    {
        return deck.getNextCard();
    }
}
