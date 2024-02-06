package com.pluralsight;

public class DiceApplication
{
    public static void main(String[] args)
    {
        Die[] dice = new Die[2];
        dice[0] = new Die();
        dice[1] = new Die();

        int rolled2 = 0;
        int rolled4 = 0;
        int rolled6 = 0;
        int rolled7 = 0;

        for (int i = 1; i <= 100; i++)
        {
            int value = roll(dice, i);
            switch (value)
            {
                case 2:
                    rolled2++;
                    break;
                case 4:
                    rolled4++;
                    break;
                case 6:
                    rolled6++;
                    break;
                case 7:
                    rolled7++;
                    break;
            }

        }

        System.out.println();
        System.out.printf("2 was rolled %d times \n", rolled2);
        System.out.printf("4 was rolled %d times \n", rolled4);
        System.out.printf("6 was rolled %d times \n", rolled6);
        System.out.printf("7 was rolled %d times \n", rolled7);
    }

    public static int roll(Die[] dice, int rollNumber)
    {
        for(Die die: dice){
            die.roll();
        }
        int one = dice[0].getValue();
        int two = dice[1].getValue();
        System.out.printf("Roll %3d: %d - %d   Sum: %d \n", rollNumber, one, two, one + two);

        return  one + two;
    }
}
