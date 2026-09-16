/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_poe1;

import java.util.Scanner;

/**
 *
 * @author leago
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Login login = new Login ();
        
        System.out.println("=== Chat App - Registration ===");
        
        String FirstName;
        String LastName;
        String UserName;
        String Password;
        String CellPhoneNumber;
        String RegistrationResult;
        
        do {
            System.out.println("Enter First Name: ");
            FirstName = scanner.nextLine();
            
            System.out.println("Enter Last Name: ");
            LastName = scanner.nextLine();
            
            System.out.println("Enter Username (must contain '_' and must not be more than 5 characters): ");
            UserName = scanner.nextLine();
            
            System.out.println("Enter password (a minimum of 8 characters, a capital letter, a number, a special character): ");
            Password = scanner.nextLine();
            
            System.out.println("Enter valid South African cell phone number: ");
            CellPhoneNumber = scanner.nextLine();
            
            RegistrationResult = login.registerUser (FirstName, LastName, UserName, Password, CellPhoneNumber);
            System.out.println(RegistrationResult);
            System.out.println();
            
        } while (!RegistrationResult.startsWith("Username Successfully Captured"));
        
        System.out.println("=== Chat App - Login ===");
        System.out.println("Enter Username: ");
        String loginUsername = scanner.nextLine();
        System.out.println("Enter Password: ");
        String loginPassword = scanner.nextLine();
        
        System.out.println(login.returnLoginStatus(loginUsername, loginPassword));
        
        scanner.close();
    }
}
