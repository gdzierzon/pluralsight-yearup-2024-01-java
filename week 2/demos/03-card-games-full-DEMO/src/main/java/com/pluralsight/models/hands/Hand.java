package com.pluralsight.models.hands;

import com.pluralsight.models.cards.Card;
import com.pluralsight.models.cards.Valuable;

import java.util.ArrayList;
import java.util.List;

public class Hand implements Valuable
{
    protected List<Card> cards;

    public Hand()
    {
        cards = new ArrayList<Card>();
    }

    public void deal(Card card)
    {
        cards.add(card);
    }

    public List<Card> getCards()
    {
        return cards;
    }

    @Override
    public int getValue()
    {
    	int value = 0;
    	
    	for (Card card : cards)
		{
			value += card.getValue();
		}
    	
    	return value;
    }

    @Override
    public int[] getPossibleValues()
    {
        if(hasMultipleValues())
        {
            return new int[] {
                getHighestValue(),
                getLowestValue()
            };
        }

        return new int[] {getValue()};
    }

    @Override
    public int getHighestValue()
    {
        int value = 0;

        for (Card card : cards)
        {
            value += card.getHighestValue();
        }

        return value;
    }

    @Override
    public int getLowestValue()
    {
        int value = 0;

        for (Card card : cards)
        {
            value += card.getLowestValue();
        }

        return value;
    }

    @Override
    public boolean hasMultipleValues()
    {
        for(Card card : cards)
        {
            if(card.hasMultipleValues())
                return true;
        }

        return false;
    }

    public void toggleCardValue(int cardNumber)
    {
        if(cardNumber > 0 && cardNumber <= cards.size())
        {
            Card card = cards.get(cardNumber - 1);
            card.toggleValue();
        }
    }

    public void show()
    {
        for(Card card : cards)
        {
            if(!card.isFaceUp())
            {
                card.flip();
            }
        }
    }

    public void hide()
    {
        for(Card card : cards)
        {
            if(card.isFaceUp())
            {
                card.flip();
            }
        }
    }

    public void discard(Card card)
    {
        // add logic to deal with if the card is not in the hand
        if(cards.contains(card))
        {
            cards.remove(card);
        }
    }
}
