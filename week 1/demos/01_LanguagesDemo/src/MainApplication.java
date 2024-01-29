public class MainApplication {

    // public static void main - this is the entry point of the program
    public static void main(String[] args) {

        // priting to screen
        System.out.println("HTML");
        System.out.println("CSS");

        // declaring and initializing variables
        String name = "Gregor";
        char firstInitial = 'G';
        int age = 49;
        double cashOnHand = 0.25;

        // calculating the cost of cookies
        System.out.println("Calculating the cost of cookies");
        System.out.println("---------------------------------");
        double priceOfCookie = 1.25;
        int numberOfCookies = 2;
        double totalCost = priceOfCookie * numberOfCookies;
        System.out.println("Total cost of cookies: " + totalCost);
    }
}
