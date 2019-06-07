package com.example.android.theshecode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class InspireHerFragment extends Fragment {

    InspireHerAdapter adapter_Ih;
    ListView ihListView;
    ArrayList<InspireHerItem> inspire_her_list;

    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View inspireHerView =  inflater.inflate(R.layout.fragment_inspireher, container, false);

       Button submit  = (Button)inspireHerView.findViewById(R.id.submit_ih);

        //instead of creating an array list, we create an array list in the form of json string. We create an array list in there only.
        //if it already exists, we store it as a json string in shared pref. so that it is loaded again even if the app is re-started.
        //this entire functionality is in loadData(). It is placed in the beginning, b/c we want the data to be loaded first as soon as this fragment is loaded.
        loadData();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //adding info to object by obtaining the text from edit text and then converting it to string to initialise the object

                //finding the edit text for obtaining info to be put in object
                EditText nameEditText = (EditText)inspireHerView.findViewById(R.id.nameET);
                String name = nameEditText.getText().toString();

                EditText locationEditText = (EditText)inspireHerView.findViewById(R.id.locationET);
                String location = locationEditText.getText().toString();

                EditText achievementEditText = (EditText)inspireHerView.findViewById(R.id.achievementET);
                String ach = achievementEditText.getText().toString();



                if(!name.matches("") && !location.matches("") && !ach.matches(""))
                    inspire_her_list.add(new InspireHerItem(name, location, ach));

                //to be put here because we need to save the data as json first before setting the adapter else, we wont be able to save it
                //once we add an item to the list, we convert it to a json string, store it in a shared pref editor.
                //hence, after we add the item to the list, we store it. This is done in saveData()
                saveData();

                   nameEditText.setText("");
                   locationEditText.setText("");
                   achievementEditText.setText("");
            }
        });

        adapter_Ih = new InspireHerAdapter(getActivity(), inspire_her_list);
        ihListView = (ListView)inspireHerView.findViewById(R.id.listView_inspireHer);
        ihListView.setAdapter(adapter_Ih);
        adapter_Ih.notifyDataSetChanged();


        return inspireHerView;
    }

    private void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(inspire_her_list);
        editor.putString("inspire her list",json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("inspire her list", null);
        Type type = new TypeToken<ArrayList<InspireHerItem>>() {}.getType();
        inspire_her_list = gson.fromJson(json, type);
        if(inspire_her_list == null){
            inspire_her_list = new ArrayList<InspireHerItem>();
        }
    }


}
