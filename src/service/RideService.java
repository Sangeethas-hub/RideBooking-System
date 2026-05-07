package service;

import model.*;

public class RideService {

    public Driver assignDriver(Driver driver)
    {
        if (driver != null)
        {
            return driver;
        }
        return null;
    }
    public Ride bookRide(int rideId, User user,Driver driver, String pickup,String drop,double distance)
    {
        Driver assignedDriver = assignDriver(driver);

        if(assignedDriver==null)
        {
            System.out.println("No driver available!");
            return null;
        }

        Cab cab = assignedDriver.getCab();

        Ride ride = new Ride(rideId,user,assignedDriver,cab,pickup,drop,distance);

        user.incrementRide();
        System.out.println("Ride booked successfully!");

        return ride;
    }
}