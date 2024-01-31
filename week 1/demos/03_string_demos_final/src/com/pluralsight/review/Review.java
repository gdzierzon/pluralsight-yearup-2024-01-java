package com.pluralsight.review;

public class Review
{
    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 1; i <= 10; i++)
        {

            System.out.print("\r[");
            System.out.print("=".repeat(i) + " ".repeat(10-i));
            System.out.print("]");
            Thread.sleep(500);
        }
    }
}
