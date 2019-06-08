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

public class MeetupFragment extends Fragment {

    MeetupAdapter meetupAdapter;
    ListView meetupListView;
    ArrayList<MeetupItem> meetupItemArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View meetup_view = inflater.inflate(R.layout.fragment_meetups, container, false);

        Button postMeetup = (Button)meetup_view.findViewById(R.id.submit_meetup);

        loadData();

        postMeetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(meetupItemArrayList.size()==0)
                {meetupItemArrayList.add(new MeetupItem("Name:PQR", "DD-YY-MM", "CompleteLocation", "Agenda of the meetup in brief"));
                }

                //extracting the text of all edit text views
                EditText organiserET = (EditText)meetup_view.findViewById(R.id.name_meetup_ET);
                String organiser_meetup = organiserET.getText().toString();

                EditText dateET = (EditText)meetup_view.findViewById(R.id.date_meetup_ET);
                String date_meetup = dateET.getText().toString();

               // EditText timeET = (EditText)meetup_view.findViewById(R.id.time_meetup_ET);
                //String time_meetup = timeET.getText().toString();


                EditText addressET = (EditText)meetup_view.findViewById(R.id.address_meetup_ET);
                String address_meetup = addressET.getText().toString();

                EditText descriptionET = (EditText)meetup_view.findViewById(R.id.description_meetup_ET);
                String description_meetup = descriptionET.getText().toString();

               if(!organiser_meetup.matches("") && !date_meetup.matches("") && !address_meetup.matches("") && !description_meetup.matches("") )
                    meetupItemArrayList.add(new MeetupItem(organiser_meetup, date_meetup, address_meetup, description_meetup));


               saveData();

             //  meetupItemArrayList.remove(1);



                organiserET.setText("");
                dateET.setText("");
               // timeET.setText("");
                addressET.setText("");
                descriptionET.setText("");
            }


        });

        meetupAdapter = new MeetupAdapter(getActivity(), meetupItemArrayList);
        meetupListView = (ListView)meetup_view.findViewById(R.id.listView_meetup);
        meetupListView.setAdapter(meetupAdapter);
        meetupAdapter.notifyDataSetChanged();



        return meetup_view;
    }



    private void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences6", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(meetupItemArrayList);
        editor.putString("meetup list",json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences6", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("meetup list", null);
        Type type = new TypeToken<ArrayList<MeetupItem>>() {}.getType();
        meetupItemArrayList = gson.fromJson(json, type);
        if(meetupItemArrayList == null){
            meetupItemArrayList = new ArrayList<MeetupItem>();
        }
    }
}
