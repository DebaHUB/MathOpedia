package com.example.mathopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mathopedia.databinding.ActivityRegistrationBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    private ActivityRegistrationBinding binding;
    private TextInputLayout nameLayout, numLayout, emLayout, pwdLayout, cfpwdLayout, usrnmLayout;
    private TextInputEditText nameEdit, numInput, emInput, pwdInput, cfpwdInput, usrnmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_registration);

        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        nameLayout = binding.nameLayout;
        nameEdit = binding.nameInput;
        usrnmInput = binding.usernameInput;
        usrnmLayout = binding.usernameLayout;
        numLayout = binding.phoneLayout;
        numInput = binding.phoneInput;
        emLayout = binding.emailLayout;
        emInput = binding.emailInput;
        pwdLayout = binding.pswdLayout;
        pwdInput = binding.pswdInput;
        cfpwdLayout = binding.cfpswdLayout;
        cfpwdInput = binding.cfpswdInput;

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        binding.regButton.setOnClickListener(view -> {
            String name = String.valueOf(nameEdit.getText());
            String usrnm = String.valueOf(usrnmInput.getText());
            String number = String.valueOf(numInput.getText());
            String email = String.valueOf(emInput.getText());
            String password = String.valueOf(pwdInput.getText());
            String cfPassword = String.valueOf(cfpwdInput.getText());

            if(validate(name,usrnm,number,email,password,cfPassword)){
                //Adding info to cloud
                registration_process(email,password,name,usrnm,number);
            }
        });
    }

    private boolean validate(String name,String usrnm, String num, String email, String pswd, String cfpswd) {
        if(name.isEmpty())
            nameLayout.setError("Field required!");
        else if(usrnm.isEmpty())
            usrnmLayout.setError("Field Required!");
        else if(num.isEmpty())
            numLayout.setError("Field required!");
        else if(num.length()!=10)
            numLayout.setError("Please provide a valid mobile number!");
        else if(email.isEmpty())
            emLayout.setError("Field required!");
        else if(pswd.isEmpty())
            pwdLayout.setError("Please set a password!");
        else if(cfpswd.isEmpty())
            cfpwdLayout.setError("Please confirm your password!");
        else if(!pswd.equals(cfpswd))
            cfpwdLayout.setError("Passwords don't match");
        else
            return true;
        return false;
    }

    private void registration_process(String email , String password, String accName, String username, String phNumber){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isComplete()){
                        FirebaseUser fuser = task.getResult().getUser();
                        String userUID = fuser.getUid();
                        storeUserDetails(userUID,accName,username,phNumber,email);
                        fuser.sendEmailVerification();
                    }
                })
                .addOnFailureListener(e -> {
                    Snackbar.make(binding.getRoot(), "Error : " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                });
    }

    private void storeUserDetails(String uid, String accName, String userName, String phnumber, String email) {
        Accounts acc = new Accounts(uid,accName,userName,phnumber,email);

        firestore.collection("UserDetails")
                .document(uid)
                .set(acc)
                .addOnCompleteListener(task -> {
                    if(task.isComplete()){
                        Snackbar.make(binding.getRoot(),"Registered Successfully",Snackbar.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Snackbar.make(binding.getRoot(), "Error : " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                });

    }
}