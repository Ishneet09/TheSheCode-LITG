package com.example.android.theshecode;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudyPartnerAdapter extends ArrayAdapter<StudyPartnerItem> {

    public StudyPartnerAdapter(Activity context, ArrayList<StudyPartnerItem> studyPartnerItemArrayList) {
        super(context, 0, studyPartnerItemArrayList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.study_list_item, parent, false);
        }

        StudyPartnerItem currentItem = getItem(position);

        TextView nameTV = (TextView)listItemView.findViewById(R.id.name_studyP);
        nameTV.setText(currentItem.getNameSP());

        TextView locationTV = (TextView)listItemView.findViewById(R.id.location_studyP);
        locationTV.setText(currentItem.getLocationSP());

        TextView achTV = (TextView)listItemView.findViewById(R.id.email_studyP);
        achTV.setText(currentItem.getEmailSP());

        TextView reasonTV = (TextView)listItemView.findViewById(R.id.reason_studyP);
        reasonTV.setText(currentItem.getReasonSP());

        return listItemView;

    }

}
