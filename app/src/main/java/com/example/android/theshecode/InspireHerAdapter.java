package com.example.android.theshecode;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class InspireHerAdapter extends ArrayAdapter<InspireHerItem> {

    public InspireHerAdapter(Activity context, ArrayList<InspireHerItem> inspireHerItemArrayList) {
        super(context, 0, inspireHerItemArrayList);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.inspire_her_list_item, parent, false);
            }

         InspireHerItem currentItem = getItem(position);

         TextView nameTV = (TextView)listItemView.findViewById(R.id.nameIH);
         nameTV.setText(currentItem.getNameIH());

         TextView locationTV = (TextView)listItemView.findViewById(R.id.locationIH);
         locationTV.setText(currentItem.getLocationIH());

         TextView achTV = (TextView)listItemView.findViewById(R.id.achievementIH);
         achTV.setText(currentItem.getAchievementIH());

        //TextView emailTV = (TextView)listItemView.findViewById(R.id.emailIH);
        //emailTV.setText(currentItem.getEmail());


        return listItemView;

    }
}