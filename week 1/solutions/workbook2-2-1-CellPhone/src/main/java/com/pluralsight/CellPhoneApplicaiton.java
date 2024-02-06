package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplicaiton
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        CellPhone phone = new CellPhone();
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

    }
}
