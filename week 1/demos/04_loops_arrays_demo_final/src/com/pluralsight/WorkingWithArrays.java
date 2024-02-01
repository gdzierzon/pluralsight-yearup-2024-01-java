package com.pluralsight;

public class WorkingWithArrays
{
    public static void main(String[] args)
    {
        // declaring an array
        int[] scores = new int[4];
        scores[0] = 98;
        scores[1] = 89;
        scores[2] = 92;
        scores[3] = 88;

        // shorthand to create common arrays
        int[] testScores = { 98, 89, 92, 88};

        String[] months = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul",
                "Aug",
                "Sep",
                "Oct",
                "Nov",
                "Dec"
        };

        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        Person[] people = new Person[4];
        people[0] = new Person("John Doe");
        people[1] = new Person("Susan H Smith");
        people[2] = new Person("Jenna Thompson, PhD");
        people[3] = new Person("Gary Patterson, III");

    }
}
