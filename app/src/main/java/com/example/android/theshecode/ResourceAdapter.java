package com.example.android.theshecode;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ResourceAdapter extends ArrayAdapter<ResourceItem> {

    private View listItemView;
    private Context context;
    private int resource;
    private ArrayList<ResourceItem> resourcesList;

    public ResourceAdapter(Context context,int resource, ArrayList<ResourceItem> resourcesList) {
        super(context, 0, resourcesList);
       // this.resource_id = resource_id;
          this.context = context;
          this.resource = resource;
          this.resourcesList = resourcesList;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent){

       /* View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.resource_item, parent, false);
        }*/

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItemView=inflater.inflate(resource, parent,false);

        ResourceItem currentResource = getItem(position);

        TextView TopicTextView = (TextView) listItemView.findViewById(R.id.topic);
        TopicTextView.setText(currentResource.getTopic());

        TextView EnglishTextView = (TextView) listItemView.findViewById(R.id.link);
        EnglishTextView.setText(currentResource.getLink());


        return listItemView;






       /* TextView TopicTextView = (TextView) listItemView.findViewById(R.id.topic);
        TopicTextView.setText(currentResource.getTopic());

        TextView EnglishTextView = (TextView) listItemView.findViewById(R.id.link);
        EnglishTextView.setText(currentResource.getLink());*/



    }
}
