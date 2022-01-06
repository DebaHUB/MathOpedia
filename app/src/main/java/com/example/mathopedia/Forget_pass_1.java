package com.example.mathopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mathopedia.databinding.ActivityForgetPass1Binding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Forget_pass_1 extends AppCompatActivity {
    private ActivityForgetPass1Binding binding;
    private TextInputLayout emlayout;
    private TextInputEditText eminput;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForgetPass1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fAuth = FirebaseAuth.getInstance();
        emlayout = binding.forgetpasseml;
        eminput = binding.forgetpassemi;

        binding.rp.setOnClickListener(view -> {
            String email = String.valueOf(eminput.getText());
            if(validate(email)){
                fAuth.sendPasswordResetEmail(email);
                Snackbar.make(binding.getRoot(),"Password reset link sent to mail!",Snackbar.LENGTH_LONG).show();
            }
        });

    }

    private boolean validate(String email) {
        if(email.isEmpty())
            emlayout.setError("Field Empty!");
        else
            return true;
        return false;
    }
}