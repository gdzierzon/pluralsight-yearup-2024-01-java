package com.pluralsight.games;

public class Card {
	private final String suit;
	private final String rank;
	private final int points;

	private boolean faceUp = false;

	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
		if(rank == "A")
		{
			this.points = 11;
		}
		else if(rank.equalsIgnoreCase("T") ||rank.equalsIgnoreCase("J") || rank.equalsIgnoreCase("Q") ||rank.equalsIgnoreCase("K"))
		{
			this.points = 10;
		}
		else
		{
			this.points = Integer.parseInt(rank);
		}
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

	public int getPoints()
	{
		return points;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	@Override
	public String toString() {
		if (faceUp) {
			return rank + suit + ":" + points;
		} else {
			return "##";
		}
	}
}
