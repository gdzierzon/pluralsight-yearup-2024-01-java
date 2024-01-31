package com.pluralsight.strings;

public class StringDemoApplication
{
    public static void main(String[] args)
    {
        basicStringFunctions();
        System.out.println();

        System.out.println(creditCardLast4("4111222233335678"));
        System.out.println(creditCardLast4("5111222233333456"));
        System.out.println(creditCardLast4("611133339999"));

        System.out.println();
        int numberOfWords = countWords("The quick brown fox jumped over the lazy dog.");
        System.out.println("There are " + numberOfWords + " in the sentence.");
    }

    public static void basicStringFunctions()
    {
        String word1 = "Hello";
        word1 = word1 + " Cody";
        String word2 = word1.toUpperCase();

        String firstLetter = word1.substring(0,1);

        System.out.println(word1);
        System.out.println(word2);
    }

    public static String creditCardLast4(String cc)
    {
        //4111111111115678
        //371111111112356

        int startPosition = cc.length() - 4;
        String last4 = cc.substring(startPosition);

        return last4;
    }

    public static int countWords(String sentence)
    {
        String[] words = sentence.split(" ");

        return words.length;
    }
}
