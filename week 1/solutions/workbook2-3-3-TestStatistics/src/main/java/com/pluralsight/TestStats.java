package com.pluralsight;

import java.util.Arrays;
import java.util.Collections;

public class TestStats
{
    public static void main(String[] args)
    {
        int[] scores = { 98, 92, 89, 81, 93, 78, 85, 94, 99, 100 };


        // sort the array to easily get the high, low and median
        Arrays.sort(scores);
        int total = 0;
        int lowScore = scores[0];
        int highScore = scores[9];

        for(int score: scores)
        {
            total += score;
        }

        double average = (double)total/ scores.length;
        double median = (double)(scores[4] + scores[5])/2;

        System.out.println();
        System.out.println("The high score is: " + highScore);
        System.out.println("The low score is: " + lowScore);
        System.out.println("The average score is: " + average);
        System.out.println("The median score is: " + median);
    }
}
