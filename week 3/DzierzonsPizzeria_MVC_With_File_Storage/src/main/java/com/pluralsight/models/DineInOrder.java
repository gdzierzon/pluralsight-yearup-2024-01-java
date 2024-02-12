package com.pluralsight.models;

public class DineInOrder extends Order
{
    private String reservationTime;
    private int numberOfGuests;
    private int table;
    private String server;

    public DineInOrder(String name)
    {
        super(name);
    }

    public String getReservationTime()
    {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime)
    {
        this.reservationTime = reservationTime;
    }

    public int getNumberOfGuests()
    {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests)
    {
        this.numberOfGuests = numberOfGuests;
    }

    public int getTable()
    {
        return table;
    }

    public void setTable(int table)
    {
        this.table = table;
    }

    public String getServer()
    {
        return server;
    }

    public void setServer(String server)
    {
        this.server = server;
    }

    @Override
    public String toString()
    {
        return String.format("dinein,%s,%s,%s,%s,%s", super.toString(),reservationTime,numberOfGuests, table, server);
    }

}
