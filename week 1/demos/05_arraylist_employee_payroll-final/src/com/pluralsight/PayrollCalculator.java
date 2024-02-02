package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SequencedCollection;

public class PayrollCalculator
{
    public static void main(String[] args)
    {
        // load the employees.csv file and process payroll
        ArrayList<Employee> employees = loadPayroll();

        System.out.println();
        for(Employee employee : employees)
        {
            System.out.println(employee.getPayrollFormat());
        }
        System.out.println("-".repeat(50));
        System.out.println();

        System.out.println("Total Pay: " + calculateTotalPay(employees));
    }

    public static ArrayList<Employee> loadPayroll()
    {
        ArrayList<Employee> employeeList = new ArrayList<>();

        // 1 define my source
        String filePath = "files/employees2.csv";
        File payrollFile = new File(filePath);

        // 2 load the file
        try(Scanner fileScanner = new Scanner(payrollFile))
        {
            // skip the first line by reading it before we start looping
            fileScanner.nextLine();

            // 3 loop through all line in the file
            // and create an employee object from each line
            while(fileScanner.hasNext())
            {
                String employeeLine = fileScanner.nextLine();

                String[] columns = employeeLine.split(",");
                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                double hours = Double.parseDouble(columns[2]);
                double payRate = Double.parseDouble(columns[3]);

                Employee employee = new Employee(id, name, hours, payRate);

                // add the current employee to the list
                employeeList.add(employee);

            }

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        // output
        return employeeList;
    }

    public static double calculateTotalPay(ArrayList<Employee> employees)
    {
        // create the aggregate container
        double totalPay = 0;

        // loop through all employees, and add their total pay amounts
        for(Employee employee : employees)
        {
            totalPay += employee.getTotalPay();
        }

        return totalPay;
    }
}
