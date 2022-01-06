package com.example.mathopedia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private ArrayList<TopicListModel> topicListModels;
    private RecyclerView rvTopic;
    private Button btn1, btn2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btn1.setOnClickListener(view -> {
            startActivity(new Intent(HomeScreen.this,TopicsActivity.class));
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(HomeScreen.this,AboutScreen.class));
        });

        rvTopic = findViewById(R.id.recycler_view_topics);

        topicsData();

        showRecyclerCardView();
    }

    public void showRecyclerCardView(){
        rvTopic.setLayoutManager(new LinearLayoutManager(this));
        CardViewTopicAdapter cardViewTopicAdapter = new CardViewTopicAdapter(this);
        cardViewTopicAdapter.setTopics(topicListModels);
        rvTopic.setAdapter(cardViewTopicAdapter);
    }

    public void topicsData(){
        topicListModels = new ArrayList<>();

        topicListModels.add(new TopicListModel("Functions", "functions",
                "#fff", R.drawable.sets_and_functions));
        topicListModels.add(new TopicListModel("Matrices", "matrices",
                "#fff", R.drawable.algebra));
        topicListModels.add(new TopicListModel("Calculus", "calculus",
                "#fff", R.drawable.calculus));
        topicListModels.add(new TopicListModel("Probability", "probability",
                "#fff", R.drawable.probability_permutation_combination));
        topicListModels.add(new TopicListModel("Trigonometry", "trigonometry",
                "#fff", R.drawable.sets_and_functions));
    }
}