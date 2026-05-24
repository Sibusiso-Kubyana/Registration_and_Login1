package com.mycompany.registration_and_login1;

public class Login { // checking if the user meets certain conditions before granting access

    boolean checkUserName(String username) {

        return username.length() <= 5
                && username.contains("_");
    }

    boolean checkPasswordComplexity(String password) {

        return password.matches(
                "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_]).{8,}$"
        );
    }

    boolean checkCellPhoneNumber(String cellnumber) {

        return cellnumber.matches(
                "^\\+[0-9]{1,3}[0-9]{1,15}$"
        );
    }

    String registerUser(String username, String password) {

        if (checkUserName(username)
                && checkPasswordComplexity(password)) {

            return "User registered successfully";

        } else {

            return "User registration failed";
        }
    }

    boolean loginUser(
            String login_username,
            String username,
            String login_password,
            String password
    ) {

        return login_username.equals(username)
                && login_password.equals(password);
    }

    String returnLoginStatus(
            String login_username,
            String username,
            String login_password,
            String password
    ) {

        if (login_username.equals(username)
                && login_password.equals(password)) {

            return "A successful login";

        } else {

            return "A failed login";
        }
    }
}