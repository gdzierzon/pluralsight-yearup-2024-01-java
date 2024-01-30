import java.util.Scanner;

public class Bakery
{
    public static void main(String[] args)
    {
        // variable declaration
        Scanner userInput = new Scanner(System.in);

        String name;
        String type;
        double pricePerDozen;
        int quantity;
        double totalPrice;
        double discount = 0;

        // input
        System.out.println("Cookies");
        System.out.println(" (S)ugar - $5.99 / dz");
        System.out.println(" (C)hocolate Chip - $7.99 / dz");
        System.out.print("Please choose a type of cookie: ");
        type = userInput.nextLine();
        System.out.println();

        System.out.print("How many dozen do you want? ");
//        quantity = Integer.parseInt(userInput.nextLine());
        quantity = userInput.nextInt();
        userInput.nextLine();

        System.out.print("What name can I put this order under? ");
        name = userInput.nextLine();

        // work
        if(type.equalsIgnoreCase("s"))
        {
            pricePerDozen = 5.99;
        }
        else
        {
            pricePerDozen = 7.99;
        }

        if(quantity >= 5)
        {
            discount = .1;
        }

        totalPrice = pricePerDozen * quantity;
        totalPrice -= totalPrice * discount;


        // output
        System.out.println("Order for " + name);
        System.out.println("Order total: $" + totalPrice);
    }
}
