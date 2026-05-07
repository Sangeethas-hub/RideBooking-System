package model;
import java.time.*;
public class Ride {
// Ride details
	private int rideId;                   // ride number
	private User user;                    // user who booked ride
	private Driver driver;                //  assigned driver
	private Cab cab;                      //  cab used for ride
	private String pickup;                //  pickup location
	private String drop;                 //   drop location
	private double distance;             //   distance in km
	private double totalFare;            //   calculated fare
	private LocalDateTime pickupTime;    //  ride start time
	
	//constructor -> creates a ride booking
	public Ride(int rideId, User user, Driver driver, Cab cab, String pickup, String drop, double distance)
	{
		this.rideId=rideId;
		this.user=user;
		this.driver=driver;
		
		//get cab from driver(Driver HAS-A Cab)
		this.cab= driver.getCab();
		
		this.pickup=pickup;
		this.drop=drop;
		this.distance=distance;
		
		//Polymorphism -> fare depends on the actual cab type
		this.totalFare = cab.calculateFare(distance);
		
		// automatically store current date & time
		this.pickupTime = LocalDateTime.now();
	}
	
	//return total fare
	public double getTotalFare()
	{
		return totalFare;
	}
	
	// print ride information
	public void displayRideDetails()
	{
		System.out.println("RIDE ID: "+rideId);
		System.out.println("USER: "+ user.getName());
		System.out.println("DRIVER: "+driver.getName());
		System.out.println("VEHICLE TYPE "+cab.getCabType());
		System.out.println("FARE : "+ totalFare);
		System.out.println("PICKUP TIME: "+pickupTime);
	}
}
