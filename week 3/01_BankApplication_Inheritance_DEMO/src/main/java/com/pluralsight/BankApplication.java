package com.pluralsight;

public class BankApplication
{
    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount("12345",25);
        System.out.println(bankAccount.getAccountName());
        System.out.println("Balance: " + bankAccount.getBalance());
        System.out.println("Withdraw $1000");
        bankAccount.withdraw(1000);
        System.out.println("Balance: " + bankAccount.getBalance());

        System.out.println();
        System.out.println("Checking account");
        CheckingAccount checking = new CheckingAccount("98765", 100);
        System.out.println(checking.getAccountName());
        System.out.println("Balance: " + checking.getBalance());
        System.out.println("Withdraw $1000");
        checking.withdraw(500);
        System.out.println("Balance: " + checking.getBalance());

    }
}
