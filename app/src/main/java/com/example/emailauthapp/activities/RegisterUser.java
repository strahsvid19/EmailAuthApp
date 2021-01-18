package com.example.emailauthapp.activities;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser {

    public static void createNewUser (FirebaseAuth mAuth, Context context, EditText email, EditText password) {

        mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString())
                .addOnCompleteListener(task -> {
                   if (task.isSuccessful()) {
                       Toast.makeText(context, "Account has been created!", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
                });
    }
}
