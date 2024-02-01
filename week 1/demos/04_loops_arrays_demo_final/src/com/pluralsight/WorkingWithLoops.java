package com.pluralsight;

import java.util.Scanner;

public class WorkingWithLoops
{
    public static void main(String[] args)
    {

    }

    public static void forLoop()
    {

        int[] scores = { 98, 89, 92, 88};
        for (int i = 0; i < 4; i++)
        {
            int score = scores[i];
            System.out.print(score + " ");
        }
    }

    public static void forEachLoop()
    {
        int[] scores = { 98, 89, 92, 88};
        for (int score : scores)
        {
            System.out.print(score + " ");
        }

    }

    public static void whileLoop()
    {
        Scanner userInput = new Scanner(System.in);
        String goAgain = "y";

        while(goAgain.equalsIgnoreCase("y"))
        {
            System.out.println("Greag");
        }
    }
}
