package com.pluralsight;

public class Person
{
    // encapsulation
    private String name;
    private int age;

    // properties
    public String getName()
    {
        if(name == null)
        {
            return "No name given";
        }

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
