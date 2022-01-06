package com.example.mathopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AboutScreen extends AppCompatActivity {
    LinearLayout personalinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_screen);

        personalinfo = findViewById(R.id.personalinfo);
        personalinfo.setVisibility(View.VISIBLE);

    }
}