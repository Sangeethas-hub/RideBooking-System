package model;

public class Cab {
//cab properties
private String cabNumber;      // vehicle number
private String cabType;       //  type: hatchback / SUV / Sedan
private double basefare;     //  minimum starting fare
private double priceperKm;   // cost per km

// Constructor -> initializes cab details
public Cab(String cabNumber, String cabType, double basefare, double priceperkm)
{
	this.cabNumber=cabNumber;
	this.cabType=cabType;
	this.basefare=basefare;
	this.priceperKm=priceperkm;
	
}

//Getter Methods -> used to access private data
 public String getCabNumber()
 {
	return cabNumber;
 }
 public String getCabType()
 {
	return cabType;
 }
 public double getBasefare()
 {
     return basefare;
 }

 public double getPriceperKm()
 {
	return priceperKm;
 }

// Fare calculation logic
// formuula = base fare + (distance * price per km)

 public double calculateFare(double distance)
 {
	 double fare = basefare+(distance * priceperKm);
	 return fare;
 }
}
