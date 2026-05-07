package model;

public class SUV extends Cab
{
	
	public SUV(String cabNumber)
	{
		super(cabNumber, "SUV", 15.0, 1.00);
	}
	
	public double calculateFare(double distance)
	{
		if(distance>20)
		{
			return distance*2.0;
		}
		else
		{
			//Normal Fare below 10km
			double fare = getBasefare() + (distance * getPriceperKm());
			// if distance id b/w 10 and 20 km (inclusive)
			// Apply 10% discount
			if(distance >= 10 && distance <= 20)
			{
				fare = fare - (fare * 0.10);
			}
			return fare;
		}
	}
}
