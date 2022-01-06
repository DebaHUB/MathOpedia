package com.example.mathopedia;

public class TopicListModel {
    String topicName, topicDesc, topicColor;
    int topicImg;

    public TopicListModel(String topicName, String topicDesc, String topicColor, int topicImg) {
        this.topicName = topicName;
        this.topicDesc = topicDesc;
        this.topicColor = topicColor;
        this.topicImg = topicImg;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getTopicColor() {
        return topicColor;
    }

    public void setTopicColor(String topicColor) {
        this.topicColor = topicColor;
    }

    public int getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(int topicImg) {
        this.topicImg = topicImg;
    }
}
