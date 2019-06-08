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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseReference userDatabase = FirebaseDatabase.getInstance().getReference("newUserSignUp");

        Button loginButton = (Button) findViewById(R.id.login);
        final TextView signUpTV = (TextView) findViewById(R.id.newUserTV);

        final EditText emailLogin = (EditText) findViewById(R.id.email_login);
        final EditText passwordLogin = (EditText) findViewById(R.id.password_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = emailLogin.getText().toString();
                final String password = passwordLogin.getText().toString();


                userDatabase.orderByChild("email").equalTo(email).limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            for (DataSnapshot key : data.getChildren()) {
                                if (key.getKey() != null && key.getKey().equals("password")) {
                                    if (String.valueOf(key.getValue()).equals(password)) {
                                        Intent navigation_screen = new Intent(MainActivity.this, navigationActivity.class);
                                        startActivity(navigation_screen);
                                        return;
                                    } else {
                                        String str = "Wrong Password entered!";
                                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                                        return;
                                    }
                                }
                            }
                        }
                        String str = "Please Register first!";
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterByTextV.class);
                startActivity(i);
            }
        });

    }
}


