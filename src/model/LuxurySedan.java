package model;

public class LuxurySedan extends Cab {

	public LuxurySedan(String cabNumber)
	{
		super(cabNumber, "LUXURY SEDAN", 10.0, 0.50);
	}
	
	public double calculateFare(double distance)
	{
		
		// If distance is more than 20 km
		// Apply flat rate rule (Special condition)
		
		if(distance>20)
		{
			return distance*2.0; //charge 2.0 per km(no base fare used)
		}
		else
		{
			//Normal Fare below 10km
			double fare = getBasefare() + (distance * getPriceperKm());
			// If distance is between 10 and 20 km (inclusive)
			// Apply 10% discount 
			if(distance >=10 && distance <=20)
			{
				fare = fare - (fare * 0.10);
			}
			return fare;
		}
	}
}
