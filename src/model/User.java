package model;
import java.util.*;
public class User 
{
	//Data members
   private int userId;   //Unique id for user
   private String name;  //User name
   private String phone; //User phone number
   private int totalRides; // How many rides user completed
   private String otp; // Stores generated OTP temporarily
	
   
   //constructor -> used when new user object is created
   public User(int userId, String name, String phone)
   {
	   this.userId=userId;
	   this.name=name;
	   this.phone=phone;
	   this.totalRides=0; // Initially user has taken 0 rides
   }
   
   //Getter Method -> returns user id
   public int getUserId()
   {
	   return userId;
   }
   
   //Getter Method -> returns user's name
   public String getName()
   {
	   return name;
   }
   
   
   public int getTotalRides() {
       return totalRides;
   }

   // Increases total ride count by 1 // Call this method after a ride is completed
   public void incrementRide()
   {
       totalRides++;
   }
   
   //method Overloading - same method name, different parameters
   
   // Update only name
   public void updateProfile(String name)
   {
	   this.name=name;
   }
   
   //Update both name and phone
   public void updateProfile(String name, String phone)
   {
	   this.name=name;
	   this.phone=phone;
   }
   
   //Generate 4-digit OTP
   public String generateOTP()
   {
	   Random random = new Random();
	   
	   //generates number between 1000 and 9999
	   int num = 1000 + random.nextInt(9000);
	   
	   otp = String.valueOf(num);  // convert int -> String
	   return otp;
   }
   
   //Verify OTP entered by user
   public boolean verifyOTP(String userOTP)
   {
	   boolean b=false;
	   
	   //compare generated OTP with user entered OTP
	   if(otp != null && otp.equals(userOTP))
	   {
		   b=true;
	   }
	   return b; // Return true if matched, else false
   }
}
