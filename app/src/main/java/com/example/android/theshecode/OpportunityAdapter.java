package com.example.android.theshecode;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OpportunityAdapter extends ArrayAdapter<OpportunityItem> {

    public OpportunityAdapter(Activity context, ArrayList<OpportunityItem> opportunityItemArrayList) {
        super(context, 0, opportunityItemArrayList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.opportunity_list_item, parent, false);
        }

        OpportunityItem currentItem = getItem(position);

        TextView formTV = (TextView)listItemView.findViewById(R.id.name_oppTV);
        formTV.setText(currentItem.getForm());

        TextView deadlineTV = (TextView)listItemView.findViewById(R.id.deadline_oppTV);
        deadlineTV.setText(currentItem.getDeadline());

        TextView descriptionTV = (TextView)listItemView.findViewById(R.id.description_oppTV);
        descriptionTV.setText(currentItem.getDescription());



        return listItemView;

    }
}
