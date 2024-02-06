package com.pluralsight;

public class SavingsAccount extends BankAccount
{
    private static final double MINIMUM_BALANCE = 5.00;

    public SavingsAccount(String accountName, double balance)
    {
        // super refers to the BankAccount class, from which we are inheriting
        // the call to the super constructor MUST be the first function call
        super(accountName, balance);
    }

    @Override // overriding is polymorphism - we are changing the way the withdraw function works
    public double withdraw(double amount)
    {
        if(getBalance() - amount < MINIMUM_BALANCE)
        {
            throw new RuntimeException("The withdrawal would put your balance below the minimum balance of " + MINIMUM_BALANCE);
        }

        // super refers to the BankAccount version of withdraw instead of calling this function again
        return super.withdraw(amount);
    }
}
