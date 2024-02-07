package com.pluralsight.models.cards;

public class Card implements Valuable
{	
	// private variables
	private final String faceValue;
	private final int value;
	private final String color;
	private boolean isFaceUp;
	
	// constructors
	public Card(int value, String color, String faceValue)
	{
		this.faceValue = faceValue;
		this.value = value;
		this.color = color;
	}

	//getters
	public String getFaceValue()
	{
		return faceValue;
	}

	public String getColor()
	{
		return color;
	}

	@Override
	public int getValue()
	{
		return value;
	}

	public void toggleValue() { /* no default implementation for cards with single value */ }

	@Override
	public int getHighestValue()
	{
		return getValue();
	}

	@Override
	public int getLowestValue()
	{
		return getValue();
	}

	@Override
	public boolean hasMultipleValues()
	{
		// by default cards only have 1 value
		return false;
	}

	@Override
	public int[] getPossibleValues()
	{
		return new int[] {getValue()};
	}

	public boolean isFaceUp()
	{
		return isFaceUp;
	}

	public void flip()
	{
		isFaceUp = !isFaceUp;
	}
	
	@Override
	public String toString()
	{
		if(!isFaceUp)
		{
			return "??";
		}
		else 
		{
			return this.getValue() + "";
		}
	}


}
