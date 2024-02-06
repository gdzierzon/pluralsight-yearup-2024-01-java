package com.pluralsight;

public class BankApplication
{
    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount("12345",25);
        System.out.println(bankAccount.getAccountName());
        System.out.println(bankAccount.getBalance());

        System.out.println();
        System.out.println("Withdrawing $100");
        double balance = bankAccount.withdraw(100);
        System.out.println(balance + " should equal " + bankAccount.getBalance());

        System.out.println();
        System.out.println("Depositing $100");
        balance = bankAccount.deposit(100);
        System.out.println(balance + " should equal " + bankAccount.getBalance());
    }
}
