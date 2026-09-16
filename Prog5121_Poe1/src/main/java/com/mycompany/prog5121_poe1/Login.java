/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe1;

import java.util.regex.Pattern;

/**
 *
 * @author leago
 */

// South African cell numbers: the '+' plus the '27' international
    // country code, followed by no more than ten further digits.
public class Login {
    private static final Pattern CELL_PHONE_NUMBER = Pattern.compile("^\\+27\\d{1,10}$");
    
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Password;
    private String CellPhoneNumber;
    
    public Login() {
    }
    //Makes sure that the username is not longer than five characters and that it has an underscore '_'
    
    public boolean checkUserName(String UserName) {
        if (UserName == null) {
        return false; 
        }
        return UserName.contains("_") && UserName.length() <= 5;
    }
    // Makes sure that a password is at least eight characters long and contains a
    // capital letter, a number, and a special character.
    
    public boolean checkPasswordComplexity(String Password) {
        if (Password == null || Password.length() < 8) {
            return false;
        }
        boolean hasCapital = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : Password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasCapital && hasDigit && hasSpecial;
    }
    // a cell phone number is the correct length and contains the
    // South African international country code (+27).
    public boolean checkCellPhoneNumber(String CellPhoneNumber) {
        return CellPhoneNumber != null && CELL_PHONE_NUMBER.matcher(CellPhoneNumber).matches();
    }

    //Validates and stores a new user's registration details.
     //Username, then password, then cell phone number registration checks are in order.
     //@return a message describing the outcome of registration.
    
    public String registerUser(String FirstName,
        String LastName,
        String UserName,
        String Password, 
        String CellPhoneNumber) {
        
        if (!checkUserName(UserName)) {
            return "Username is not correctly formatted; please ensure that your "
                    + "username contains an underscore and is no more than five "
                    + "characters in length.";
        }
        
        if (!checkPasswordComplexity(Password)) {
            return "Password is not correctly formatted; please ensure that the "
                    + "password contains at least eight characters, a capital "
                    + "letter, a number, and a special character.";
        }
        
        if (!checkCellPhoneNumber(CellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain "
                    + "international code.";
        }
        
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.Password = Password;
        this.CellPhoneNumber = CellPhoneNumber;
        
        return "Username successfully captured. Password successfully captured. "
                + "Cell phone number successfully added. Registration successful, "
                + "welcome " + FirstName + " " + LastName + "!";
    }

    //Verifies that the supplied username and password match the details
     //logged in by the user.
    
    public boolean loginUser(String UserName, String Password) {
        return this.UserName != null 
                && this.UserName.equals(UserName)
                && this.Password != null
                && this.Password.equals(Password);
    }

    // Appropriate message is retrned for a login attempt.
    
    public String returnLoginStatus(String UserName, String Password) {
        if (loginUser(UserName, Password)) {
            return "Welcome " + FirstName + ", " + LastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
    
    public String GetFirstName() {
        return FirstName;
    }
    public String GetLastName() {
        return LastName;
    }
    public String GetUserName() {
        return UserName;
    }
    public String GetCellPhoneNumber() {
        return CellPhoneNumber;
    }
}
