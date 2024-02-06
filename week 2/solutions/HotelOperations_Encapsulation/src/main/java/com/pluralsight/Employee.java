package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee
{
    public final double FULL_TIME_HOURS = 40;
    public final double OVERTIME_RATE = 1.5;

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double shiftStartTime;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public double getPayRate()
    {
        return payRate;
    }

    public void setPayRate(double payRate)
    {
        this.payRate = payRate;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    // derived properties
    public double getRegularHours()
    {
        if(hoursWorked > FULL_TIME_HOURS)
            return FULL_TIME_HOURS;

        return hoursWorked;
    }

    public double getOverTimeHours()
    {
        if(hoursWorked > FULL_TIME_HOURS)
            return hoursWorked - FULL_TIME_HOURS;

        return 0;
    }

    public double getTotalPay()
    {
        double pay = getRegularHours() * payRate;
        pay += getOverTimeHours() * payRate * OVERTIME_RATE;

        return pay;
    }

    // methods
    public void punchIn(double time)
    {
        shiftStartTime = time;
    }
    public void punchIn()
    {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour();
        time += now.getMinute() / 60.0;

        punchIn(time);
    }

    public void punchOut(double time)
    {
        // calculate shift hours
        double shiftTotal = time - shiftStartTime;
        // add shift hours to total hours
        hoursWorked += shiftTotal;
        // reset shift start
        shiftStartTime = 0;
    }

    public void punchOut()
    {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour();
        time += now.getMinute() / 60.0;

        punchOut(time);
    }
}
