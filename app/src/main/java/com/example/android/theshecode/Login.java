package com.example.android.theshecode;

public class Login {
    String email;
    String password;

    public Login(){

    }

    public Login(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

}