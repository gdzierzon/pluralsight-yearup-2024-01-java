package com.pluralsight;

public class ClassDemo
{
    public static void main(String[] args)
    {
        Person person1 = new Person();
        Person person2 = new Person("John", "", "Doe","");
        Person person3 = new Person("John H Doe, Jr");

        System.out.println(person1.getFullName());
        System.out.println(person2.getFullName());
        System.out.println(person3.getFullName());

    }
}
