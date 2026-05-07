package model;

// Hatchback IS-A Cab (Inheritance)
public class Hatchback extends Cab {

	//constructor -> sends fixed values to parent cab class
	public Hatchback(String cabNumber)
	{
		super(cabNumber,"Hatchback", 5.0, 0.25);
	}
	
	// Method Overriding -> changing fare calculation for Hatchback
	public double calculateFare(double distance)
	{
		//if distance is more than 20 km
		//special offer: flat 2 per km (no base fare)
		
		if(distance > 20)
		{
			return distance * 2.0;
		}
		
		else
		{
			//Normal fare: base fare + (distance * price/km)
			double fare = getBasefare() + (distance * getPriceperKm());
			
			// if distancec between 10 km and 20 km -> 10% discount
			if(distance >=10 && distance <=20)
			{
				fare = fare - (fare * 0.10);
		
			}
			return fare;
		}
	}
}
