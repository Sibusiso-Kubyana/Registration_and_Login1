/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration_and_login1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Registration_and_Login1 {
   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Login login = new Login();

        //Declaring variables for global use
        String username = "";
        String password = "";
        String cellnumber = "";

        System.out.println("Welcome to QuickChat."); // REQUIRED

       
        // USERNAME REGISTRATION
       

        while (true) { //Loop until username conditions are met

            System.out.println("Enter username:");
            username = scan.nextLine();

            if (login.checkUserName(username)) {
                System.out.println("Username successfully captured");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            }
        }

        
        // PASSWORD REGISTRATION
        

        while (true) { //Loop until conditions for password are met

            System.out.println("Enter your new password");
            password = scan.nextLine();

            if (login.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character");
            }
        }

      
        // CELL NUMBER REGISTRATION
      

        while (true) { //Loop until it meets the required conditions for cellphone

            System.out.println("Enter your cell phone number");
            cellnumber = scan.nextLine();

            if (login.checkCellPhoneNumber(cellnumber)) {
                System.out.println("Cell phone number successfully added");
                break;
            } else {
                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
            }
        }

       
        // REGISTER USER
       

        System.out.println(login.registerUser(username, password));

       
        // LOGIN PROCESS
       

        boolean isLoggedIn = false;

        while (true) {

            System.out.println("Enter username to login:");
            String login_user = scan.nextLine();

            System.out.println("Enter password to login:");
            String login_pass = scan.nextLine();

            if (login.loginUser(login_user, username, login_pass, password)) {
                System.out.println(login.returnLoginStatus(login_user, username, login_pass, password));
                isLoggedIn = true;
                break;
            } else {
                System.out.println("Username or password incorrect please try again");
            }
        }

       
        // MAIN MENU LOOP
       

        int totalMessages = 0;

        while (true) {

            System.out.println("\nMENU:");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            String choice = scan.nextLine();

            if (choice.equals("1")) {

                // HOW MANY MESSAGES USER WANTS
                System.out.println("How many messages do you want to send?");
                int numMessages = Integer.parseInt(scan.nextLine());

                for (int i = 0; i < numMessages; i++) {

                    System.out.println("\nEnter recipient number:");
                    String recipient = scan.nextLine();

                    System.out.println("Enter your message:");
                    String content = scan.nextLine();

                    Message msg = new Message(recipient, content);

                    // Validate recipient
                    System.out.println(msg.checkRecipientCell());

                    // Validate message length 
                    String validation = msg.checkMessageContent(content);

                    if (!validation.equals("Message ready to send.")) {
                        System.out.println(validation);
                        continue;
                    }

                    System.out.println(validation);

                    
                    System.out.println("Message Hash: " + msg.createMessageHash());

                    // ACTION MENU
                    System.out.println("\n1. Send Message");
                    System.out.println("2. Disregard Message");
                    System.out.println("3. Store Message to send later");

                    String action = scan.nextLine();

                    System.out.println(msg.SentMessage(action));

                    if (action.equals("1")) {

                        totalMessages++;

                        System.out.println("\nMessage ID: " + msg.getMessageID());
                        System.out.println("Message Hash: " + msg.createMessageHash());
                        System.out.println("Recipient: " + recipient);
                        System.out.println("Message: " + content);
                    }
                }

                System.out.println("\nTotal messages sent: " + totalMessages);
            }

            else if (choice.equals("2")) {
                System.out.println("Coming Soon.");
            }

            else if (choice.equals("3")) {
                System.out.println("Goodbye.");
                break;
            }

            else {
                System.out.println("Invalid option.");
            }
        }

        scan.close();
    }
}