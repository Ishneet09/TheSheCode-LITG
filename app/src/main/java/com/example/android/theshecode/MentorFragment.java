package com.example.android.theshecode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MentorFragment extends Fragment {

    MentorAdapter mentorAdapter;
    ListView mentorListView;
    ArrayList<MentorItem> mentorItemArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View mentor_view = inflater.inflate(R.layout.fragment_mentor, container, false);

        Button sign_up_mentor = (Button)mentor_view.findViewById(R.id.submit_mentor);

        for(int i = 8; i>=5; i--)
            mentorItemArrayList.remove(i);


        loadData();

        sign_up_mentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mentorItemArrayList.size()==0) {
                    mentorItemArrayList.add(new MentorItem("Name:PQR", "State,Country", "e-mai:prq@mail.com", "Intro:Write about who you are, your achievements, communities volunteering or anything which makes you proud of yourself. The reader can then contact you."));
                }

                //extracting the text of all edit text views
                EditText mName = (EditText)mentor_view.findViewById(R.id.name_mentor_ET);
                String mentor_name = mName.getText().toString();

                EditText mLocation = (EditText)mentor_view.findViewById(R.id.location_mentor_ET);
                String mentor_location = mLocation.getText().toString();

                EditText mEmail = (EditText)mentor_view.findViewById(R.id.email_mentor_ET);
                String mentor_email = mEmail.getText().toString();

                EditText mIntro = (EditText)mentor_view.findViewById(R.id.intro_mentor_ET);
                String mentor_intro = mIntro.getText().toString();

               if(!mentor_name.matches("") && !mentor_location.matches("") && !mentor_email.matches("") && !mentor_intro.matches("") )
                    mentorItemArrayList.add(new MentorItem(mentor_name, mentor_location, mentor_email, mentor_intro));


               saveData();

               for(int i = 8; i>=5; i--)
                   mentorItemArrayList.remove(i);



                mName.setText("");
                mLocation.setText("");
                mEmail.setText("");
                mIntro.setText("");
            }


        });

        mentorAdapter = new MentorAdapter(getActivity(), mentorItemArrayList);
        mentorListView = (ListView)mentor_view.findViewById(R.id.listView_mentor);
        mentorListView.setAdapter(mentorAdapter);
        mentorAdapter.notifyDataSetChanged();

        mentorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MentorItem currentItem = (MentorItem) adapterView.getItemAtPosition(i);
                String[] emailAddress = { currentItem.getEmailM() };
                Intent mentor_intent = new Intent(Intent.ACTION_SENDTO);
                mentor_intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                mentor_intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                mentor_intent.putExtra(Intent.EXTRA_TEXT, "Write your message here and don't forget to put an appropriate subject as per your needs!(Give a reference to 'TheSheCode')-");
                startActivity(mentor_intent);

            }
        });

        return mentor_view;
    }



    private void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mentorItemArrayList);
        editor.putString("mentor list",json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences1", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("mentor list", null);
        Type type = new TypeToken<ArrayList<MentorItem>>() {}.getType();
        mentorItemArrayList = gson.fromJson(json, type);
        if(mentorItemArrayList == null){
            mentorItemArrayList = new ArrayList<MentorItem>();
        }
    }
}
