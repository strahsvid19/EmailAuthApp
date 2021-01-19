package com.example.emailauthapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class RegisterUser {

    public static void createNewUser (Activity a, FirebaseAuth mAuth, Context context, EditText email, EditText password) {

        mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString())
                .addOnCompleteListener(task -> {
                   if (task.isSuccessful()) {
                       Toast.makeText(context, "Account has been created!", Toast.LENGTH_SHORT).show();
                       a.startActivity(new Intent(context, MainActivity.class));
                       a.finish();
                   } else {
                       Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
                });
    }

    public static void signInUser (Activity a, FirebaseAuth mAuth, Context context, EditText email, EditText password) {

        mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        a.startActivity(new Intent(context, HomeActivity.class));
                        a.finish();
                    } else {
                        Toast.makeText(context, "The email or password is not correct", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
