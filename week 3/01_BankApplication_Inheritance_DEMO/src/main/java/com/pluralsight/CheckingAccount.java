package com.pluralsight;

// the term extends BankAccount means I am inheriting from BankAccount
// BankAccount becomes the "super" class
public class CheckingAccount extends BankAccount
{
    private static final double MAXIMUM_OVERDRAFT = -500;

    public CheckingAccount(String accountName, double balance)
    {
        // make a call to the constructor of BankAccount
        // pass required parameters to the super constructor
        super(accountName, balance);
    }

    public double withdraw(double amount)
    {
        double newBalance = getBalance() - amount;
        if(newBalance >= MAXIMUM_OVERDRAFT)
        {
            // we can withdraw the money
            // super refers to the parent class
            return super.withdraw(amount);
        }
        else
        {
            // we CAN'T withdraw the money
            // just return the current balance instead
            return getBalance();
        }
    }
}
