package com.example.emailauthapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.emailauthapp.databinding.ActivityUpdateEmailBinding;
import com.example.emailauthapp.firebase_settings.User;
import com.example.emailauthapp.validators.Validators;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class UpdateEmailActivity extends AppCompatActivity {

    ActivityUpdateEmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateEmailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.currentEmail.setText(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail());
        binding.currentEmail.setEnabled(false);

        binding.btnUpdate.setOnClickListener(v -> {
            if (Validators.emailValidate(binding.newEmail)) {
                User.updateUserEmail(this, FirebaseAuth.getInstance(), binding.newEmail);
            }
        });
    }
}