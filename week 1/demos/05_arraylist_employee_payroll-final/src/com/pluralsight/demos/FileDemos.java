package com.pluralsight.demos;

import java.io.File;

public class FileDemos
{
    public static void main(String[] args)
    {
        File employeesFile = new File("files/employee.csv");
        System.out.println(employeesFile.getAbsolutePath());
        System.out.println("the specified path is a file: " + employeesFile.isFile());
        System.out.println("the specified path is a directory: " + employeesFile.isDirectory());
        System.out.println("the specified path exists: " + employeesFile.exists());
    }
}
