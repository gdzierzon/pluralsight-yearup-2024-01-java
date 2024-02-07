package com.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        int[] mynumbers = {5,8,1,3,6};
        int sum = sumUnlucky13(mynumbers);
        System.out.println(sum);
    }

    public static int sumUnlucky13(int[] numbers)
    {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            int number = numbers[i];

            if(i+1 < numbers.length)
            {
                int next = numbers[i + 1];

                if (number == 1 && next == 3)
                {
                    continue;
                }
            }

            sum += number;
        }

        return sum;
    }
}