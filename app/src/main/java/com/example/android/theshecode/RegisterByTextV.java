package com.example.android.theshecode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class RegisterByTextV extends AppCompatActivity {
    Spinner skills;
    ArrayAdapter<CharSequence> spinnerAdapter;
    DatabaseReference usersDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_by_text_v);

        //getting reference for firebase
        usersDatabase = FirebaseDatabase.getInstance().getReference("newUserSignUp");

        //setting onClick listener on signUp button
        Button signUpButton = (Button)findViewById(R.id.signUp);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtaining name
                EditText nameEditText =(EditText)findViewById(R.id.name);
                String name = nameEditText.getText().toString();

                //Obtaining email
                EditText emailEditText = (EditText)findViewById(R.id.email);
                String email = emailEditText.getText().toString();

                //Obtaining password
                EditText passwordEditText = (EditText)findViewById(R.id.password);
                String password = passwordEditText.getText().toString();

                //obtaining confirm password
                EditText confirmPassword = (EditText)findViewById(R.id.password_confirm);
                String editTextConfirmPassword = confirmPassword.getText().toString();


                //Obtaining LinkedIn URL
                EditText linkedInEditText = (EditText)findViewById(R.id.linkedInURL);
                String linkedIn = linkedInEditText.getText().toString();

                //Obtaining skills
                Spinner skillsSpinner = (Spinner)findViewById(R.id.skills);
                String skillsFromSpinner = skillsSpinner.getSelectedItem().toString();

                //Obtaining experience level

                RadioGroup experienceRgrp = (RadioGroup)findViewById(R.id.radio_group);
                // get selected radio button from radioGroup
                int selectedButtonId = experienceRgrp.getCheckedRadioButtonId();
                //find the radio button by selected ID
                RadioButton experience_button = (RadioButton)findViewById(selectedButtonId);
                //getting the text experience from selected radio button
                String experience = experience_button.getText().toString();

                //getting the address
                EditText addressEditText = (EditText)findViewById(R.id.address);
                EditText stateEditText = (EditText)findViewById(R.id.state);
                EditText countryEditText = (EditText)findViewById(R.id.country);
                String address = addressEditText.getText().toString();
                String country = countryEditText.getText().toString();
                String state = stateEditText.getText().toString();

                //checking if password match.If not-
                if(!password.equals(editTextConfirmPassword)){

                    CharSequence text = "Passwords do not match!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                }


               else {
                    //adding the user in database
                    String fireBaseId = usersDatabase.push().getKey();
                    //creating new user object
                    Registration newUser = new Registration(name, email, password, linkedIn, country, state, skillsFromSpinner, address, experience);
                    //adding the user to database
                    usersDatabase.child(fireBaseId).setValue(newUser);
                }

                Intent goToNavigationScreen = new Intent(RegisterByTextV.this, navigationActivity.class);
                startActivity(goToNavigationScreen);
                }

        });

        //Checking if the passwords entered are matching!
        EditText password = (EditText) findViewById(R.id.password);
        EditText confirmPassword = (EditText)findViewById(R.id.password_confirm);

        String editTextPassword = password.getText().toString();
        String editTextConfirmPassword = confirmPassword.getText().toString();
        if(!editTextPassword.equals(editTextConfirmPassword)){

            CharSequence text = "Passwords do not match!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }

        //Making a spinner for skills
        skills = (Spinner)findViewById(R.id.skills);
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.skill_set, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skills.setAdapter(spinnerAdapter);
    }


}
