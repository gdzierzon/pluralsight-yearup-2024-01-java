package com.pluralsight.games;

public class Card {
	private final String suit;
	private final String value;

	private boolean faceUp = false;

	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;

	}

	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}

	public String getSuit() {
		return this.suit;
	}

	public String getValue	() {
		return value;
	}

	public int getPointValue()
	{
		if(value.equalsIgnoreCase("A"))
		{
			return 11;
		}
		else if(value.equalsIgnoreCase("T") ||value.equalsIgnoreCase("J") || value.equalsIgnoreCase("Q") ||value.equalsIgnoreCase("K"))
		{
			return 10;
		}
		else
		{
			return Integer.parseInt(value);
		}
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	@Override
	public String toString() {
		if (faceUp) {
			return value + suit + ":" + getPointValue();
		} else {
			return "##";
		}
	}
}
