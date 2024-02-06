package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplicaiton
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        CellPhone phone = new CellPhone();
        CellPhone phone2;
        int serialNumber;
        String model;
        String carrier;
        String phoneNumber;
        String owner;

        System.out.print("What is the serial number? ");
        serialNumber = userInput.nextInt();
        userInput.nextLine();
        System.out.print("What model is the phone? ");
        model = userInput.nextLine();
        System.out.print("Who is the carrier? ");
        carrier = userInput.nextLine();
        System.out.print("What is the phone number? ");
        phoneNumber = userInput.nextLine();
        System.out.print("Who is the owner of the phone? ");
        owner = userInput.nextLine();

        phone.setSerialNumber(serialNumber);
        phone.setModel(model);
        phone.setCarrier(carrier);
        phone.setPhoneNumber(phoneNumber);
        phone.setOwner(owner);

        phone2 = new CellPhone(987654321, "Samsung S21", "AT&T", "888-555-1212", "Larry");

        display(phone);
        display(phone2);

        System.out.println();
        phone.dial(phone2.getPhoneNumber());
        phone2.dial(phone);

    }

    public static void display(CellPhone phone)
    {
        System.out.println();
        System.out.println("Phone Information");
        System.out.println("-----------------");
        System.out.println(phone.getOwner());
        System.out.println(phone.getPhoneNumber());
        System.out.println(phone.getModel());
        System.out.println(phone.getCarrier());
        System.out.println(phone.getSerialNumber());
    }
}
