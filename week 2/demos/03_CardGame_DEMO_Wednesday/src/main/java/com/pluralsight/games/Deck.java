package com.pluralsight.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> listOfCards = new ArrayList<>();

	public Deck() {
		for (String suit : new String[] { "C", "S", "D", "H" }) {
			for (String value : new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" }) {
				Card currentCard = new Card(suit, value);
				listOfCards.add(currentCard);
			}
		}
	}

	/**
	 * Shuffles the deck of cards randomly. Uses the Collections.shuffle static method.
	 */
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}

	/**
	 * Deals a card from the deck.
	 * @return the top card from the deck
	 */
	public Card deal() {
		if (size() != 0) {
			return listOfCards.remove(0);
		} else {
			return null;
		}
	}

	// Delegation method
	public int size() {
		return listOfCards.size();
	}

	private void flip() {
		for (Card playingCard : listOfCards) {
			playingCard.flip();
		}
	}

	@Override
	public String toString() {
		this.flip();
		String myselfAsString = "Deck [listOfCards=" + listOfCards + "]";
		this.flip();
		return myselfAsString;
	}

}
