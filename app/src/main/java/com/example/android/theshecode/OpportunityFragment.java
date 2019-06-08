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

public class OpportunityFragment extends Fragment {

    OpportunityAdapter opportunityAdapter;
    ListView opportunityListView;
    ArrayList<OpportunityItem> opportunityItemArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View opportunity_view = inflater.inflate(R.layout.fragment_opportunities, container, false);

        Button post_opp = (Button)opportunity_view.findViewById(R.id.submit_opp);

        loadData();

        post_opp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(opportunityItemArrayList.size()==0) {
                    opportunityItemArrayList.add(new OpportunityItem("Name:XYZ Co.", "Deadline:DD-YY-MM", "Description:Opening for full stack developer for Seattle region.2-3 years experience, proficiency in C++. Apply via company website"));
                }

                //extracting the text of all edit text views
                EditText oppFormET = (EditText)opportunity_view.findViewById(R.id.form_opp_ET);
                String oppForm = oppFormET.getText().toString();

                EditText oppDeadlineET = (EditText)opportunity_view.findViewById(R.id.deadline_opp_ET);
                String oppDeadline = oppDeadlineET.getText().toString();

                EditText oppDescriptionET = (EditText)opportunity_view.findViewById(R.id.description_opp_ET);
                String oppDescription = oppDescriptionET.getText().toString();


                  if(!oppForm.matches("") && !oppDeadline.matches("") && !oppDescription.matches(""))
                   opportunityItemArrayList.add(new OpportunityItem(oppForm, oppDeadline, oppDescription));


                saveData();

                opportunityItemArrayList.remove(1);


               oppFormET.setText("");
               oppDeadlineET.setText("");
               oppDescriptionET.setText("");

            }


        });

        opportunityAdapter = new OpportunityAdapter(getActivity(), opportunityItemArrayList);
        opportunityListView = (ListView)opportunity_view.findViewById(R.id.listView_opp);
        opportunityListView.setAdapter(opportunityAdapter);
        opportunityAdapter.notifyDataSetChanged();



        return opportunity_view;
    }



    private void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences4", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(opportunityItemArrayList);
        editor.putString("opportunity list",json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences4", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("opportunity list", null);
        Type type = new TypeToken<ArrayList<OpportunityItem>>() {}.getType();
        opportunityItemArrayList = gson.fromJson(json, type);
        if(opportunityItemArrayList == null){
            opportunityItemArrayList = new ArrayList<OpportunityItem>();
        }
    }
}



