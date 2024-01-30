import java.io.IOException;
import java.util.Scanner;

public class UserInputDemo
{
    public static void main(String[] args) throws IOException
    {
        // declare your scanner
        Scanner userInput = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = userInput.nextLine();

        System.out.println("Hello " + name);
    }
}
