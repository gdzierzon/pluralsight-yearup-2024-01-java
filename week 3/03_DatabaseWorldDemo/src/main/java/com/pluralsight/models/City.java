package com.pluralsight.models;

public class City
{
    private int id;
    private String name;
    private String state;
    private String country;
    private int population;

    public City()
    {
    }

    public City(int id, String name, String state, String country, int population)
    {
        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;
        this.population = population;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }
}
