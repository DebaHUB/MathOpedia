package com.example.mathopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class TopicsActivity extends AppCompatActivity {

    private TopicsActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        binding.bt.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this,Binomial_theorem.class));
        });
        binding.cn.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Complex_numbers.class));
        });
        binding.cs.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Conic_sections.class));
        });
        binding.de.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Differential_equations.class));
        });
        binding.itg.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Geometry.class));
        });
        binding.it.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Integrals.class));
        });
        binding.ld.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Limits_derivatives.class));
        });
        binding.mm.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Matrices.class));
        });
        binding.pm.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Permutations_combinations.class));
        });
        binding.pp.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Probability.class));
        });
        binding.rf.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Relations_functions.class));
        });
        binding.ss.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Sequence_series.class));
        });
        binding.tf.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Trigonometric_functions.class));
        });
        binding.iv.setOnClickListener(view -> {
            startActivity(new Intent(TopicsActivity.this, Vectors.class));
        });
    }
}