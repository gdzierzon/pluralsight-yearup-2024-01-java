package com.pluralsight;

public class BankAccount
{
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double balance)
    {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public double getBalance()
    {
        return balance;
    }

    public double withdraw(double amount)
    {
        if(amount <= balance)
        {
            balance -= amount;
        }
        return balance;
    }

    public double deposit(double amount)
    {
        balance += amount;
        return balance;
    }
}
