package com.example.emailauthapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.emailauthapp.databinding.ActivityUpdatePasswordBinding;
import com.example.emailauthapp.firebase_settings.User;
import com.example.emailauthapp.validators.Validators;
import com.google.firebase.auth.FirebaseAuth;

public class UpdatePasswordActivity extends AppCompatActivity {

    ActivityUpdatePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdatePasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnUpdate.setOnClickListener(v -> {

            if (Validators.passwordValidate(binding.newPassword, binding.confirmPassword)) {
                User.updatePassword(this, FirebaseAuth.getInstance(), binding.newPassword);
            }
        });
    }
}