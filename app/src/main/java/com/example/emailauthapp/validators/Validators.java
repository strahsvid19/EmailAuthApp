package com.example.emailauthapp.validators;

import android.util.Patterns;
import android.widget.EditText;

public class Validators {

    public static boolean validateInput (EditText email, EditText password, EditText confirmPassword) {
        return emailValidate(email) && passwordValidate(password, confirmPassword);
    }

    public static boolean emailValidate (EditText email) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()) {
            email.setError("Incorrect email address");
            email.requestFocus();
            return false;
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Empty email address");
            email.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean passwordValidate (EditText password, EditText confirmPassword) {
        if (password.length() < 6) {
            password.setError("Min length of the password is 6 letters");
            password.requestFocus();
            return false;
        } else if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
            confirmPassword.setError("Different passwords");
            confirmPassword.requestFocus();
            return false;
        }
        return true;
    }
}
