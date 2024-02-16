package com.pluralsight.services;

import com.pluralsight.models.Dealer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealerService
{
    private final String DEALER_FILE_PATH = "data/dealers.csv";

    public List<Dealer> getAllDealers()
    {
        List<Dealer> dealers = new ArrayList<>();
        File file = new File(DEALER_FILE_PATH);

        try(Scanner scanner = new Scanner(file))
        {
            scanner.nextLine();

            while(scanner.hasNext())
            {
                String line = scanner.nextLine();;
                String[] columns = line.split(",");

                int id =Integer.parseInt(columns[0]);
                String name = columns[1];
                String address = columns[2];
                String city = columns[3];
                String state = columns[4];
                String zip = columns[5];
                String phone = columns[6];

                Dealer dealer = new Dealer(id, name, address, city, state, zip, phone);

                dealers.add(dealer);
            }
        }
        catch (FileNotFoundException e)
        {
        }


        return dealers;
    }
}
