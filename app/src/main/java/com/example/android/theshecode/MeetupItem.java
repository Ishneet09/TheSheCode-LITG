package com.example.android.theshecode;

public class MeetupItem {

    private String organiser;
    private String date;
    private String time;
    private String address;
    private String description;

    MeetupItem(){

    }

    public MeetupItem(String organiser, String date, String time, String address, String description){
        this.organiser = organiser;
        this.date = date;
        this.time = time;
        this.address = address;
        this.description = description;
    }

    public String getOrganiser() {
        return organiser;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}
