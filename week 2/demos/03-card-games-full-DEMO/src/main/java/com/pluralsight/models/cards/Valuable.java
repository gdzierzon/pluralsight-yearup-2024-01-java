package com.pluralsight.models.cards;

public interface Valuable
{
    int getValue();
    boolean hasMultipleValues();
    int[] getPossibleValues();
    int getHighestValue();
    int getLowestValue();
}
