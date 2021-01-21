package com.example.emailauthapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.emailauthapp.databinding.ActivityRegisterBinding;
import com.example.emailauthapp.firebase_settings.User;
import com.example.emailauthapp.validators.Validators;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();

        binding.btnReg.setOnClickListener(v -> {
            if (Validators.validateInput(binding.email, binding.password, binding.confirmPassword)) {
                User.createNewUser(this, mAuth, binding.email, binding.password);
            }
        });
    }
}