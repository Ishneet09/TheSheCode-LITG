package com.example.android.theshecode;

public class MentorItem {

    private String name;
    private String location;
    private String email;
    private String intro;

    public MentorItem(){

    }

    public MentorItem(String name, String location, String email, String intro){
        this.name = name;
        this.location = location;
        this.email = email;
        this.intro = intro;
    }

    public String getNameM() {
        return name;
    }

    public String getLocationM() {
        return location;
    }

    public String getEmailM() {
        return email;
    }

    public String getIntroM() {
        return intro;
    }
}
