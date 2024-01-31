package com.pluralsight;

public class EncapsulationApplication
{
    public static void main(String[] args)
    {

        Person person1;
        person1 = new Person();


        // because name and age are private
        // we CAN'T access them directly
//        person1.name = "Gregor";
//        person1.age = 49;

        // we need to use the getters and setters
        person1.setName("Gregor");
        person1.setAge(49);

        System.out.println(person1.getName() + " is " + person1.getAge());


    }
}
