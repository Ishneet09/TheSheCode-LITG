package com.example.android.theshecode;

import android.app.Activity;
import android.media.TimedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MentorAdapter extends ArrayAdapter<MentorItem> {

    public MentorAdapter(Activity context, ArrayList<MentorItem> mentorItemArrayList) {
        super(context, 0, mentorItemArrayList);
    }

    @Override

     public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.mentor_list_item, parent, false);
        }

       MentorItem currentItem = getItem(position);

        TextView nameTV = (TextView)listItemView.findViewById(R.id.name_mentor);
        nameTV.setText(currentItem.getNameM());

        TextView locationTV = (TextView)listItemView.findViewById(R.id.location_mentor);
        locationTV.setText(currentItem.getLocationM());

        TextView email = (TextView)listItemView.findViewById(R.id.email_mentor);
        email.setText(currentItem.getEmailM());

        TextView intro = (TextView)listItemView.findViewById(R.id.intro_mentor);
        intro.setText(currentItem.getIntroM());


        return listItemView;

    }

}
