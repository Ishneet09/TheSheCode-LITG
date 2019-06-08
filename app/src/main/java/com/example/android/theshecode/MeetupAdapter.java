package com.example.android.theshecode;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MeetupAdapter extends ArrayAdapter<MeetupItem> {

    public MeetupAdapter(Activity context, ArrayList<MeetupItem> meetupItemArrayList) {
        super(context, 0, meetupItemArrayList);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.meetup_list_item, parent, false);
        }

        MeetupItem currentItem = getItem(position);

        TextView organiserTV = (TextView) listItemView.findViewById(R.id.organiser_meetup_TV);
        organiserTV.setText(currentItem.getOrganiser());

        TextView dateTV = (TextView) listItemView.findViewById(R.id.date_meetupTV);
        dateTV.setText(currentItem.getDate());

       // TextView timeTV = (TextView) listItemView.findViewById(R.id.time_meetupTV);
        //timeTV.setText(currentItem.getTime());

        TextView addressTV = (TextView) listItemView.findViewById(R.id.address_meetupTV);
        addressTV.setText(currentItem.getAddress());

        TextView descriptionTV = (TextView) listItemView.findViewById(R.id.description_meetupTV);
        descriptionTV.setText(currentItem.getDescription());


        return listItemView;


    }
}
