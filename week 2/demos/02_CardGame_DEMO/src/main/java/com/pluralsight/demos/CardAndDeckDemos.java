package com.pluralsight.demos;

import com.pluralsight.games.Card;
import com.pluralsight.games.Deck;
import com.pluralsight.games.Hand;

public class CardAndDeckDemos
{

	public static void main(String[] args) {

		Card aceOfSpades = new Card("s", "A");
//		System.out.println(aceOfSpades.getSuit());
//		aceOfSpades.flip();
		System.out.println(aceOfSpades.toString());

		aceOfSpades.flip();

		System.out.println(aceOfSpades);
//
//		Card twoOfHearts = new Card("h", "2");
//		twoOfHearts.flip();
//		System.out.println(twoOfHearts);

		Deck deckOfCards = new Deck();

		System.out.println(deckOfCards);

		deckOfCards.shuffle();

		System.out.println(deckOfCards);

		Card topCard = deckOfCards.deal();
		topCard.flip();

		System.out.println(topCard);
		topCard.flip();


		System.out.println(deckOfCards);

		Hand gaby = new Hand("Gaby");
		System.out.println("Gaby has " + gaby.getSize() + " cards");
		System.out.println(gaby.getValue());
		gaby.deal(topCard);
		gaby.deal(deckOfCards.deal());
		gaby.deal(deckOfCards.deal());
		gaby.deal(deckOfCards.deal());
		System.out.println("Gaby has " + gaby.getSize() + " cards");
		System.out.println(gaby.getValue());
		gaby.showHand();
	}

}
