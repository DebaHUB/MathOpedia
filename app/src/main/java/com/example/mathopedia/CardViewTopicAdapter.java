package com.example.mathopedia;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardViewTopicAdapter extends RecyclerView.Adapter<CardViewTopicAdapter.CardViewHolder> {

    private HomeScreen context;
    private ArrayList<TopicListModel> Topics;

    public HomeScreen getContext() {
        return context;
    }

    public void setContext(HomeScreen context) {
        this.context = context;
    }

    public ArrayList<TopicListModel> getTopics() {
        return Topics;
    }

    public void setTopics(ArrayList<TopicListModel> topics) {
        this.Topics = topics;
    }

    public CardViewTopicAdapter(HomeScreen context){
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_topics,
                parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        TopicListModel topicListModel = getTopics().get(position);

        holder.tvTopicTitle.setText(topicListModel.getTopicName());
        holder.tvTopicShortDesc.setText(topicListModel.getTopicDesc());
        holder.imgTopics.setImageResource(topicListModel.getTopicImg());
        holder.cardViewBg.setCardBackgroundColor(Color.parseColor(topicListModel.getTopicColor()));
    }

    @Override
    public int getItemCount() {
        return getTopics().size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTopics;
        TextView tvTopicTitle, tvTopicShortDesc;
        CardView cardViewBg;

        public CardViewHolder(@NonNull View itemView){
            super(itemView);

            imgTopics = itemView.findViewById(R.id.img_item_topic);
            tvTopicTitle = itemView.findViewById(R.id.tv_item_title);
            tvTopicShortDesc = itemView.findViewById(R.id.tv_item_short_desc);
            cardViewBg = itemView.findViewById(R.id.card_view_bg);

        }
    }
}