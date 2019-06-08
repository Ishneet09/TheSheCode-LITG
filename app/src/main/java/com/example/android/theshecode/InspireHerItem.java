package com.example.android.theshecode;

public class InspireHerItem {

    private String nameIH;
    private  String locationIH;
    private String achievementIH;
    private String email;

    public InspireHerItem(){

    }

    public InspireHerItem(String nameIH, String locationIH, String achievementIH, String email){
        this.nameIH = nameIH;
        this.locationIH = locationIH;
        this.achievementIH = achievementIH;
        this.email = email;
    }

    public String getNameIH() {
        return nameIH;
    }

    public String getLocationIH() {
        return locationIH;
    }

    public String getAchievementIH() {
        return achievementIH;
    }

    public String getEmail(){
        return email;}
}
