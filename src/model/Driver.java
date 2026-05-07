package model;

public class Driver {

	//Driver details
	private int driverId;
	private String name;
	private double rating;
	
	// HAS-A relationship b/w driver and cab
	// A Driver has a Cab(Driver owns a cab object)
	private Cab cab;
	
	//Constructor -> runs when driver object is created
	public Driver(int driverId, String name, Cab cab)
	{
		this.driverId=driverId;  // assign id
		this.name=name;         // assign name
		this.rating=5.0;       // default rating when driver joins
		this.cab=cab;         // store cab object inside driver
	}
	
	//Getter Method -> returns driver name
	public String getName()
	{
		return name;
	}
	
	//Getter Method -> returns driver's cab object
	// Other classes can access cab details through driver
	public Cab getCab()
	{
		return cab;  // Return the cab references
	}
}
