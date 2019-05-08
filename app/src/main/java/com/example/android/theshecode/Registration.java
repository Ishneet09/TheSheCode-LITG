package com.example.android.theshecode;

public class Registration {
    private String name;
    private String email;
    private String password;
    private String LinkedInURL;
    private String country;
    private String state;
    private String address;
    private String experience;
    private String profession;

    public Registration(){

    }

    public Registration(String name, String email, String password, String LinkedInURL, String country, String state,String profession,  String address, String experience ){
        this.name = name;
        this.email = email;
        this.password = password;
        this.LinkedInURL = LinkedInURL;
        this.country = country;
        this.address = address;
        this.state = state;
        this.profession = profession;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLinkedInURL() {
        return LinkedInURL;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }


    public String getExperience(){return experience; }

    public String getProfession() {
        return profession;
    }
}

