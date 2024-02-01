public class MathApp
{
    public static void main(String[] args)
    {
        // Question 1 - find the highest salary
        double bobSalary = 125000.00;
        double garySalary = 150000.00;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary i $" + highestSalary);
        System.out.println();

        // Question 2 - find the lowest price
        double carPrice = 25000;
        double truckPrice = 32000;
        double lowsetPrice = Math.min(carPrice, truckPrice);
        System.out.println("The lowest vehicle price is $" + lowsetPrice);
        System.out.println();

        // Question 3 - calculate the area of a circle
        double radius = 7.25;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of the circle is " + area);
        System.out.println();

        // Question 4 - find the distance between 2 points
        int x1 = 5, y1 = 10;
        int x2 = 85, y2 = 50;
        int width = x2 - x1;
        int height = y2 - y1;
        // a2 + b2 = c2
        double a2 = Math.pow(width, 2);
        double b2 = Math.pow(height, 2);
        double c2 = a2 + b2;
        double length = Math.sqrt(c2);
        System.out.println("The distance between points (5,10) and (85,50) is " + length);

        // Question 5 - generate random number between 1 and 10
        long number = (int)(Math.random() * 10);
        System.out.println("A random number between 1 and 10: " + number);
    }
}
