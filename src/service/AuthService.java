package service;
import model.User;

public class AuthService {

    // Method to send OTP
    public String sendOTP(User user)
    {
        // Call generateOTP method from User class
        String otp = user.generateOTP();

        System.out.println("OTP sent to user: "+ otp);
        return otp;
    }
    // Method to verify OTP
    public boolean verifyOTP(User user,String inputOtp)
    {
        // Calls verify method from User class
        boolean result = user.verifyOTP(inputOtp);

        if(result)
        {
            System.out.println("OTP verified successfully");
        }
        else {
            System.out.println("Invalid OTP!");
        }
        return result;
    }
}