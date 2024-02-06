package com.pluralsight;

public class Card {
	private String suit;
	private String rank;
	private boolean faceUp = false;

	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}

	public String getSuit() {
		return this.suit;
	}

	public String getRank() {
		return rank;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	@Override
	public String toString() {
		if (faceUp) {
			return rank + suit;
		} else {
			return "##";
		}
	}
}
