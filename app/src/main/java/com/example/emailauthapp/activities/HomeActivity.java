package com.example.emailauthapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.emailauthapp.databinding.ActivityHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if (mUser != null) {
            binding.emailHome.setText(String.format("Email - %s", mUser.getEmail()));
            binding.idHome.setText(String.format("ID - %s", mUser.getUid()));
        }

        binding.btnLogOut.setOnClickListener(v -> {
            mAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });

    }
}