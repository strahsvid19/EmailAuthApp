package com.example.emailauthapp.firebase_settings;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emailauthapp.activities.HomeActivity;
import com.example.emailauthapp.activities.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class User {

    public static void createNewUser (Activity a, FirebaseAuth mAuth, EditText email, EditText password) {

        String mEmail = email.getText().toString().trim();
        String mPassword = password.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(mEmail, mPassword)
                .addOnCompleteListener(task -> {
                   if (task.isSuccessful()) {
                       Toast.makeText(a.getApplicationContext(), "Account has been created!", Toast.LENGTH_SHORT).show();
                       a.startActivity(new Intent(a.getApplicationContext(), MainActivity.class));
                       a.finish();
                   } else {
                       Toast.makeText(a.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
                });
    }

    public static void signInUser (Activity a, FirebaseAuth mAuth, EditText email, EditText password) {

        String mEmail = email.getText().toString().trim();
        String mPassword = password.getText().toString();

        mAuth.signInWithEmailAndPassword(mEmail, mPassword)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        a.startActivity(new Intent(a.getApplicationContext(), HomeActivity.class));
                        a.finish();
                    } else {
                        Toast.makeText(a.getApplicationContext(), "The email or password is not correct", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public static void updateUserEmail (Activity a, FirebaseAuth mAuth, EditText email) {
        Objects.requireNonNull(mAuth.getCurrentUser()).updateEmail(email.getText().toString().trim());
        Toast.makeText(a.getApplicationContext(), "Email has been changed!", Toast.LENGTH_SHORT).show();
    }
}
