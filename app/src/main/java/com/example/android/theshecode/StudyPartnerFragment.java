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

public class StudyPartnerFragment extends Fragment {

    StudyPartnerAdapter studyPartnerAdapter;
    ListView study_partner_listView;
    ArrayList<StudyPartnerItem> studyPartnerItemArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View studyP_view = inflater.inflate(R.layout.fragment_studypartner, container, false);

        Button submit_studyP = (Button)studyP_view.findViewById(R.id.submit_studyP);

        loadData();

        submit_studyP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(studyPartnerItemArrayList.size()==0) {
                    studyPartnerItemArrayList.add(new StudyPartnerItem("Name:PQR", "State,Country", "e-mai:prq@mail.com", "Reason:Explain why you need a study partner. If it is for a project or research, briefly explain something about it in brief, the tech stack etc or is it for interview practice or anything."));
                }

                EditText nameET = (EditText)studyP_view.findViewById(R.id.name_study_ET);
                String name_studyP = nameET.getText().toString();

                EditText locationET = (EditText)studyP_view.findViewById(R.id.location_study_ET);
                String location_studyP = locationET.getText().toString();

                EditText emailET = (EditText)studyP_view.findViewById(R.id.email_study_ET);
                String email_studyP = emailET.getText().toString();

                EditText reasonET = (EditText)studyP_view.findViewById(R.id.reason_study_ET);
                String reason_studyP = reasonET.getText().toString();

                if(!name_studyP.matches("") && !location_studyP.matches("") && !email_studyP.matches("") && !reason_studyP.matches(""))
                    studyPartnerItemArrayList.add(new StudyPartnerItem(name_studyP, location_studyP, email_studyP, reason_studyP));


                saveData();

                nameET.setText("");
                locationET.setText("");
                emailET.setText("");
                reasonET.setText("");
            }
        });

        studyPartnerAdapter = new StudyPartnerAdapter(getActivity(), studyPartnerItemArrayList);
        study_partner_listView = (ListView)studyP_view.findViewById(R.id.listView_studyP);
        study_partner_listView.setAdapter(studyPartnerAdapter);
        studyPartnerAdapter.notifyDataSetChanged();

        study_partner_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StudyPartnerItem currentItem = (StudyPartnerItem)adapterView.getItemAtPosition(i);
                String[] emailAddress = {currentItem.getEmailSP()};
                Intent study_intent = new Intent(Intent.ACTION_SENDTO);
                study_intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                study_intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                study_intent.putExtra(Intent.EXTRA_TEXT, "Write your message here and don't forget to put an appropriate subject as per your needs!(Do give a reference to 'TheSheCode')-");
                startActivity(study_intent);
            }
        });


        return studyP_view;
    }

    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences2", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("study partner list", null);
        Type type = new TypeToken<ArrayList<StudyPartnerItem>>() {}.getType();
        studyPartnerItemArrayList = gson.fromJson(json, type);
        if(studyPartnerItemArrayList == null){
            studyPartnerItemArrayList = new ArrayList<StudyPartnerItem>();
        }
    }

    public void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(studyPartnerItemArrayList);
        editor.putString("study partner list",json);
        editor.apply();
    }
}
