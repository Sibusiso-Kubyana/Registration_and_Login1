package com.mycompany.registration_and_login1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testRegisterUser_UsernameIncorrect() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        
        String actual = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!");
        assertFalse(actual.contains("Username is not correctly formatted"));
    }

    @Test
public void testRegisterUser_PasswordSuccess() {
    // Call the actual method and compare
    boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
    assertTrue(actual);
}

    @Test
    public void testRegisterUser_PasswordFailure() {
        // Test Data: "password"
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellNumber_Success() {
        // Test Data: "+27838968976"
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellNumber_Failure() {
        // Test Data: "08966553"
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }



    @Test
    public void testLoginSuccessful() {
        // Test Case: Login Successful Expected: True
        assertTrue(login.loginUser("kyl_1", "kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        // Test Case: Login Failed Expected: False
        assertFalse(login.loginUser("wrong_user", "kyl_1", "wrong_pass", "Ch&&sec@ke99!"));
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        // Test Data: "kyl_1"  Expected: True
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Test Data: "kyle!!!!!!" Expected: False
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordComplexity_True() {
        // Expected: True
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordComplexity_False() {
        // Expected: False
        assertFalse(login.checkPasswordComplexity("password"));
    }
}
