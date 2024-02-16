package com.pluralsight.models;

public class DeliveryOrder extends Order
{
    // static = shared
    public static final double DELIVERY_CHARGE_PRECENT = .2;

    private String address;
    private String apartment;
    private String city;
    private String state;
    private String zip;

    public DeliveryOrder(String name)
    {
        super(name);
    }

    public DeliveryOrder(int orderId, String name, String progress, String address, String apartment, String city, String state, String zip)
    {
        super(orderId, name, progress);
        this.address = address;
        this.apartment = apartment;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getApartment()
    {
        return apartment;
    }

    public void setApartment(String apartment)
    {
        this.apartment = apartment;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public double getDeliveryCharge()
    {
        // make sure to call the getTotal of the super class
        return super.getTotal() * DELIVERY_CHARGE_PRECENT;
    }

    @Override
    public double getTotal()
    {
        // add the super total + the delivery charge
        double total = getDeliveryCharge() + super.getTotal();
        return total;
    }

    @Override
    public String toString()
    {
        return String.format("%s,delivery,%s,%s,%s,%s,%s,%s,%s", getOrderId(), getName(), getProgress(),address,apartment,city,state,zip);
    }
}
