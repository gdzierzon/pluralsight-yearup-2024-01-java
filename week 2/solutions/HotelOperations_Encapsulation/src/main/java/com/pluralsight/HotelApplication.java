package com.pluralsight;

public class HotelApplication
{
    public static void main(String[] args)
    {
        /************************
         EXERCISE 1
        *************************/

        /* ROOM TESTS */
        // create a room that is clean and unoccupied
        // verify that it IS available
        System.out.println();
        Room kingRoom = new Room(1, 139.00, false, false);
        System.out.println("The king room should be available");
        System.out.println("expect: true - actual: " + kingRoom.isAvailable());

        // create a room that is dirty and occupied
        // verify that it IS NOT available
        System.out.println();
        Room doubleRoom = new Room(2, 124.00, true, true);
        System.out.println("The double room should NOT be available");
        System.out.println("expect: false - actual: " + doubleRoom.isAvailable());


        /* RESERVATION TESTS */
        // create a reservation for a King room for 2 weekday nights
        // verify that the price per night is $139
        // verify that the total reservation cost is $278
        System.out.println();
        Reservation kingReservation = new Reservation("King", 2, false);
        System.out.println("New reservation created:");
        System.out.println("Room rate expected: 139.00 - actual: " + kingReservation.getPrice());
        System.out.println("Total cost expected: 278.00 - actual: " + kingReservation.getReservationTotal());

        // create a reservation for a double room for 2 weekend nights
        // verify that the price per night is $136.40
        // verify that the total reservation cost is $272.80
        System.out.println();
        Reservation doubleReservation = new Reservation("Double room", 2, true);
        System.out.println("New reservation created:");
        System.out.println("Room rate expected: 136.40 - actual: " + doubleReservation.getPrice());
        System.out.println("Total cost expected: 272.80 - actual: " + doubleReservation.getReservationTotal());


        /* EMPLOYEE TESTS */
        // create an employee that worked 30 hour and has a rate of $20
        // verify that the total pay is $600, regular hours is 30
        // and overtime hours is 0
        System.out.println();
        Employee employee1 = new Employee(1, "John", "Maintenance", 20.00, 30.00);
        System.out.println("New Employee: " + employee1.getName());
        System.out.println("total pay expected: 600.00 - actual: " + employee1.getTotalPay());
        System.out.println("regular hours expected: 30.00 - actual: " + employee1.getRegularHours());
        System.out.println("overtime hours expected: 0.00 - actual: " + employee1.getOverTimeHours());

        // create an employee that worked 60 hour and has a rate of $20
        // verify that the total pay is $1400, regular hours is 40
        // and overtime hours is 20
        System.out.println();
        Employee employee2 = new Employee(2, "Susan", "Maintenance", 20.00, 60.00);
        System.out.println("New Employee: " + employee2.getName());
        System.out.println("total pay expected: 1400.00 - actual: " + employee2.getTotalPay());
        System.out.println("regular hours expected: 40.00 - actual: " + employee2.getRegularHours());
        System.out.println("overtime hours expected: 20.00 - actual: " + employee2.getOverTimeHours());


        /************************
         EXERCISE 2
        *************************/

        /* ROOM TESTS */
        // create a room that is clean and unoccupied
        // call the checkin method
        // verify that the room
        //  - IS dirty
        //  - IS checked in
        //  - IS NOT available
        System.out.println();
        Room kingSuite = new Room(1, 219.00, false, false);
        System.out.println("Checking into room");
        kingSuite.checkIn();
        System.out.println("The king suite should be dirty");
        System.out.println("is dirty expected: true - actual: " + kingSuite.isDirty());
        System.out.println("The king suite should be checked in");
        System.out.println("is occupied in expected: true - actual: " + kingSuite.isOccupied());
        System.out.println("The king suite should not be available");
        System.out.println("is available expect: false - actual: " + kingSuite.isAvailable());

        // call the checkout method
        // verify that the room
        //  - IS dirty
        //  - IS NOT checked in
        //  - IS NOT available
        System.out.println();
        System.out.println("Checking out of room");
        kingSuite.checkOut();
        System.out.println("The king suite should be dirty");
        System.out.println("is dirty expected: true - actual: " + kingSuite.isDirty());
        System.out.println("The king suite should be checked out");
        System.out.println("is occupied in expected: false - actual: " + kingSuite.isOccupied());
        System.out.println("The king suite should not be available");
        System.out.println("is available expect: false - actual: " + kingSuite.isAvailable());


        // call the cleanroom method
        // verify that the room
        //  - IS clean
        //  - IS NOT checked in
        //  - IS available
        System.out.println();
        System.out.println("Cleaning room");
        kingSuite.cleanRoom();
        System.out.println("The king suite should be clean");
        System.out.println("is dirty expected: false - actual: " + kingSuite.isDirty());
        System.out.println("The king suite should be checked out");
        System.out.println("is occupied in expected: false - actual: " + kingSuite.isOccupied());
        System.out.println("The king suite should not be available");
        System.out.println("is available expect: true - actual: " + kingSuite.isAvailable());



        /* EMPLOYEE TESTS */
        // create an employee that worked 0 hour and has a rate of $20
        // call the punchIn method (10.0)
        // call the punchOut method (12.0)
        // verify the following
        // - hours worked = 2
        // - total pay = $40
        // - regular hours = 2
        // - overtime hours = 0
        System.out.println();
        Employee employee3 = new Employee(3, "Phil", "Development", 20.00, 0.00);
        System.out.println("New Employee: " + employee3.getName());
        System.out.println("Punching employee in at 10 and out at 12");
        employee3.punchIn(10);
        employee3.punchOut(12);
        System.out.println("hours worked expected: 2.00 - actual: " + employee3.getHoursWorked());
        System.out.println("total pay expected: 40.00 - actual: " + employee3.getTotalPay());
        System.out.println("regular hours expected: 2.00 - actual: " + employee3.getRegularHours());
        System.out.println("overtime hours expected: 0.00 - actual: " + employee3.getOverTimeHours());
    }
}
