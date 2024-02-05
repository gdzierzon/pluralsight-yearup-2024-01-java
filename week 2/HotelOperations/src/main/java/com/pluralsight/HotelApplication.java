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

        // create a room that is dirty and occupied
        // verify that it IS NOT available


        /* RESERVATION TESTS */
        // create a reservation for a King room for 2 weekday nights
        // verify that the price per night is $139
        // verify that the total reservation cost is $278

        // create a reservation for a double room for 2 weekend nights
        // verify that the price per night is $136.40
        // verify that the total reservation cost is $272.80


        /* EMPLOYEE TESTS */
        // create an employee that worked 30 hour and has a rate of $20
        // verify that the total pay is $600, regular hours is 30
        // and overtime hours is 0

        // create an employee that worked 60 hour and has a rate of $20
        // verify that the total pay is $1400, regular hours is 40
        // and overtime hours is 20


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

        // call the checkout method
        // verify that the room
        //  - IS dirty
        //  - IS NOT checked in
        //  - IS NOT available

        // call the cleanroom method
        // verify that the room
        //  - IS clean
        //  - IS NOT checked in
        //  - IS available


        /* EMPLOYEE TESTS */
        // create an employee that worked 0 hour and has a rate of $20
        // call the punchIn method (10.0)
        // call the punchOut method (12.0)
        // verify the following
        // - hours worked = 2
        // - total pay = $40
        // - regular hours = 2
        // - overtime hours = 0
    }
}
