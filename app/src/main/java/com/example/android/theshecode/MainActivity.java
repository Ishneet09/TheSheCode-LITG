package com.example.android.theshecode;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.theshecode.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView register_textView;
    Button login_btn;
    DatabaseReference loginDatabase = FirebaseDatabase.getInstance().getReference("newUserSignUp");;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for existing user trying to login in
        login_btn = (Button) findViewById(R.id.login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email_login = (EditText) findViewById(R.id.email_login);
                EditText pwd_login = (EditText) findViewById(R.id.password_login);

                //log the user in
                logIn(email_login.getText().toString(), pwd_login.getText().toString());
            }
        });


        //in case there is a new user
        register_textView = (TextView) findViewById(R.id.newUserTV);
        register_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(MainActivity.this, RegisterByTextV.class);
                startActivity(register);
            }
        });
    }

    public void logIn(final String email, final String password) {

        loginDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if(dataSnapshot.child(email).exists()){
                  if(!email.isEmpty()){
                      Login user = dataSnapshot.child(email).getValue(Login.class);
                      if(user.getPassword().equals(password)){

                          Intent navigation_screen = new Intent(MainActivity.this, navigationActivity.class);
                          startActivity(navigation_screen);
                      }
                      else{
                          String str = "Wrong Password entered!";
                          Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG);
                      }
                  }
                  else{
                      String str = "Please Register first!";
                      Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG);
                  }
              }
              else{
                  String str = "Please Register first!";
                  Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG);
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}


