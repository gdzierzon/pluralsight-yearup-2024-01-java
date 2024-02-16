package com.pluralsight;

import com.pluralsight.models.Car;
import com.pluralsight.models.Dealer;
import com.pluralsight.services.CarService;
import com.pluralsight.services.DealerService;
import com.pluralsight.views.UserInterface;

import java.util.List;

public class DealershipApplication
{
    private DealerService dealerService = new DealerService();
    private CarService carService = new CarService();

    private List<Dealer> dealers;

    private UserInterface ui = new UserInterface();
    private Dealer selectedDealer = null;

    public DealershipApplication()
    {
        // load all dealers into memory when application starts
        dealers = dealerService.getAllDealers();
    }

    public void run()
    {
        while(true)
        {
            selectedDealer = ui.homeScreenGetDealerId(dealers);
            if(selectedDealer == null)
            {
                // user chose to exit
                break;
            }
            enterDealersip();
        }

        ui.goodBye();
    }

    public void enterDealersip()
    {
        while(true)
        {
            int choice = ui.dealerHomeScreen(selectedDealer);

            switch(choice)
            {
                case 1: // price
                    searchByPrice();
                    break;
                case 2: // make/model
                    searchByMakeModel();
                    break;
                case 3: // year
                    searchByYear();
                    break;
                case 4: // color
                    searchByColor();
                    break;
                case 5: // miles
                    searchByMiles();
                    break;
                case 6: // type
                    searchByType();
                    break;
                case 7: // all
                    showAllCars();
                    break;
                case 8: // add car
                    addCar();
                    break;
                case 9: // remove car
                    removeCar();
                    break;
                case 99: // exit
                    // returns out of the function can goes back to home screen
                    return;
            }
        }
    }

    private void searchByPrice()
    {
        int minPrice = ui.getInt("What is the minimum price? ");
        int maxPrice = ui.getInt("What is the maximum price? ");

        List<Car> cars = carService.searchByPrice(selectedDealer.getId(), minPrice, maxPrice);
        ui.showCars(cars);

    }

    private void searchByMakeModel()
    {
    }

    private void searchByYear()
    {
    }

    private void searchByColor()
    {

    }

    private void searchByMiles()
    {

    }

    private void searchByType()
    {


    }

    private void showAllCars()
    {
        List<Car> cars = carService.getAllCars(selectedDealer.getId());
        ui.showCars(cars);
    }

    private void addCar()
    {
    }

    private void removeCar()
    {
    }
}
