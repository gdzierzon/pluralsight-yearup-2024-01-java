package com.pluralsight;

import java.io.File;

public class FileInformationDemo
{
    public static void main(String[] args)
    {
        File filesFolder = new File("files");
        File goldilocks = new File("files/goldilock.txt");

        System.out.println();
        System.out.println(filesFolder.getAbsolutePath());
        System.out.println("files is a file: " + filesFolder.isFile());
        System.out.println("files is a directory: " + filesFolder.isDirectory());
        System.out.println("files exists: " + filesFolder.exists());
        System.out.println();
        System.out.println(goldilocks.getAbsolutePath());
        System.out.println("goldilocks is a file: " + goldilocks.isFile());
        System.out.println("goldilocks is a directory: " + goldilocks.isDirectory());
        System.out.println("goldilocks exists: " + goldilocks.exists());
    }
}
