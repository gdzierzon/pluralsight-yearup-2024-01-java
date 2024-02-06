package com.pluralsight.demos;

import com.pluralsight.games.Card;
import com.pluralsight.games.Deck;

public class CardAndDeckDemos
{

	public static void main(String[] args) {
		Card aceOfSpades = new Card("s", "A");

		System.out.println(aceOfSpades);

		aceOfSpades.flip();

		System.out.println(aceOfSpades);

		Card twoOfHearts = new Card("h", "2");
		twoOfHearts.flip();
		System.out.println(twoOfHearts);

		Deck deckOfCards = new Deck();

		System.out.println(deckOfCards);

		deckOfCards.shuffle();

		System.out.println(deckOfCards);

		Card topCard = deckOfCards.deal();
		topCard.flip();

		System.out.println(topCard);

		System.out.println(deckOfCards);
	}

}
