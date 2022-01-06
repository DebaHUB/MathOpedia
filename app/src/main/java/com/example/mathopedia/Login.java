package com.example.mathopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mathopedia.chapters.Binomial_theorem;
import com.example.mathopedia.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth fAuth;
    private ActivityLoginBinding binding;
    private TextInputLayout loginEmLayout, loginPwdLayout;
    private TextInputEditText loginEmInput, loginPwdInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginEmInput = binding.loginEmailInput;
        loginEmLayout=binding.loginEmailLayout;
        loginPwdLayout=binding.loginPwdLayout;
        loginPwdInput=binding.loginPwdInput;
        fAuth = FirebaseAuth.getInstance();


        binding.loginBtn.setOnClickListener(view -> {
            String email = String.valueOf(loginEmInput.getText());
            String password = String.valueOf(loginPwdInput.getText());
            if(validate(email,password)){
                proceedForLogin(email,password);
            }
        });
        binding.registerBtn.setOnClickListener(view -> {
            startActivity(new Intent(Login.this, Registration.class));
        });
        binding.forgot.setOnClickListener(view -> {
            startActivity(new Intent(Login.this, Forget_pass_1.class));
        });
    }

    private void proceedForLogin(String email, String password){
        fAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {
                    if(task.isComplete()){
                        if(fAuth.getCurrentUser().isEmailVerified()){
                            Snackbar.make(binding.getRoot(),"WELCOME",Snackbar.LENGTH_LONG).show();
                        }
                        else{
                            Snackbar.make(binding.getRoot(),"EMAIL NOT VERIFIED. SENT VERIFICATION MAIL.",Snackbar.LENGTH_LONG).show();
                            fAuth.getCurrentUser().sendEmailVerification();
                        }
                        //NAVIGATE TO NEXT SCREEN
                    }
                    else{
                        Snackbar.make(binding.getRoot(),"Please check the credentials! Create an account if you don't have one.",Snackbar.LENGTH_LONG).show();
                        loginEmLayout.setError("");
                        loginPwdLayout.setError("");
                    }
                })
                .addOnFailureListener(e -> {
                    Snackbar.make(binding.getRoot(),"ERROR : " + e.getMessage(),Snackbar.LENGTH_LONG).show();
                });
    }
    public boolean validate(String email, String pwd) {
        if (email.isEmpty() || pwd.isEmpty()) {
            loginEmLayout.setError("Invalid Email and/or password!");
            loginPwdLayout.setError("Invalid Email and/or password!");
        }
        else
            return true;
        return false;
    }
}