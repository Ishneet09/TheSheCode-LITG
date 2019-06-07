package com.example.android.theshecode;

public class ResourceItem {

    private String topic;
    private String link;

    public ResourceItem(){

    }

    public ResourceItem(String topic, String link){
        this.topic = topic;
        this.link = link;
    }

    public String getTopic(){
        return topic;
    }

    public String getLink(){
        return link;
    }


}
