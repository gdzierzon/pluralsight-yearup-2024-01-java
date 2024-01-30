public class MathApp
{
    public static void main(String[] args)
    {
        // Question 1 - find the highest salary
        int bobSalary = 75000;
        int garySalary = 95000;
        int highestSalary = Math.max(bobSalary,garySalary);
        System.out.println("The highest salary is $" + Math.max(bobSalary,garySalary));
        System.out.println();

        // Question 2 - find the lowest price
        double carPrice = 25000;
        double truckPrice = 32000;
        System.out.println("The lowest vehicle price is $");
        System.out.println();

        // Question 3 - calculate the area of a circle
        double radius = 7.25;
        System.out.println("The area of the circle is ");
        System.out.println();

        // Question 4 - find the distance between 2 points
        int x1 = 5, y1 = 10;
        int x2 = 8, y2 = 14;
        int width = x2 - x1;
        int height = y2 - y1;
        // a2 + b2 = c2
        double a2 = Math.pow(width, 2);
        double b2 = Math.pow(height, 2);
        double c2 = a2 + b2;
        double length = Math.sqrt(c2);

        double len = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));

        System.out.println("The distance between points (5,10) and (85,50) is " + length);
        System.out.println();
        System.out.println();

        // Question 5 - generate random number between 1 and 10
        int min = 0;
        int max = 1;
        double randomNum = Math.random() * 10;
        System.out.println(randomNum);
        System.out.println("A random number between 1 and 10: " + Math.round(randomNum));
    }
}
