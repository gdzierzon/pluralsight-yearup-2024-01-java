package com.pluralsight;

public class CheckingAccount extends BankAccount
{
    private static final double MAXIMUM_OVERDRAFT = -500.00;
    private static final double OVERDRAFT_FEE = 10.00;

    public CheckingAccount(String accountName, double balance)
    {
        // super refers to the BankAccount class, from which we are inheriting
        // the call to the super constructor MUST be the first function call
        super(accountName, balance);
    }

    @Override // overriding is polymorphism - we are changing the way the withdraw function works
    public double withdraw(double amount)
    {
        if(getBalance() - amount < MAXIMUM_OVERDRAFT)
        {
            throw new RuntimeException("The withdrawal would put your balance below the maximum overdraft of " + MAXIMUM_OVERDRAFT);
        }

        // super refers to the BankAccount version of withdraw instead of calling this function again
        double newBalance = super.withdraw(amount);

        if(newBalance < 0)
        {
            // if the balance is below 0 the overdraft fee is charged
            super.withdraw(OVERDRAFT_FEE);
        }

        return getBalance();
    }
}
