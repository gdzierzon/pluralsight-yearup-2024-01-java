package com.pluralsight;

public class Reservation
{
    private final double KING_PRICE = 139.00;
    private final double DOUBLE_PRICE = 124.00;
    private final double WEEKEND_RATE_INCREASE = .10;

    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend)
    {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType()
    {
        return roomType;
    }

    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }

    public int getNumberOfNights()
    {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights)
    {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend()
    {
        return isWeekend;
    }

    public void setWeekend(boolean weekend)
    {
        isWeekend = weekend;
    }


    public double getPrice()
    {
        double price = roomType.equalsIgnoreCase("king") ? KING_PRICE : DOUBLE_PRICE;

        if(isWeekend) price += (price * WEEKEND_RATE_INCREASE);

        return price;
    }

    public double getReservationTotal()
    {
        return getPrice() * numberOfNights;
    }

}
