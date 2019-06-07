package com.example.android.theshecode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class ResourcesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View resource_view = inflater.inflate(R.layout.list_view, container, false);

        ArrayList<ResourceItem> resource_list = new ArrayList<ResourceItem>();
        resource_list.add(new ResourceItem("HTML & CSS", "https://www.tripwiremagazine.com/css3-tutorials/"));
        resource_list.add(new ResourceItem("HTML & CSS", "https://benhowdle.im/cssselectors/"));
        resource_list.add(new ResourceItem("HTML & CSS", "https://www.amazon.com/HTML-CSS-Design-Build-Websites/dp/1118008189"));
        resource_list.add(new ResourceItem("C++", "https://developers.google.com/edu/c++/"));
        resource_list.add(new ResourceItem("C++", "https://en.cppreference.com/w"));
        resource_list.add(new ResourceItem("C++", "https://www.learncpp.com/"));
        resource_list.add(new ResourceItem("Python", "https://www.fullstackpython.com/"));
        resource_list.add(new ResourceItem("Python", "https://www.coursera.org/learn/interactive-python-1"));
        resource_list.add(new ResourceItem("Python", "https://codingbat.com/python"));
        resource_list.add(new ResourceItem("JavaScript", "https://codepen.io/"));
        resource_list.add(new ResourceItem("JavaScript", "https://babeljs.io/docs/en/learn"));
        resource_list.add(new ResourceItem("JavaScript", "https://www.freecodecamp.org/"));
        resource_list.add(new ResourceItem("Java", "https://codingbat.com/java"));
        resource_list.add(new ResourceItem("Java", "https://javaranch.com/style.jsp"));
        resource_list.add(new ResourceItem("Java", "https://www.youtube.com/watch?v=grEKMHGYyns"));
        resource_list.add(new ResourceItem("Ruby", "https://rubymonk.com/"));
        resource_list.add(new ResourceItem("Ruby", "http://tutorials.jumpstartlab.com/projects/ruby_in_100_minutes.html"));
        resource_list.add(new ResourceItem("Ruby", "http://railscasts.com/"));
        resource_list.add(new ResourceItem("Data", "https://www.edx.org/course/big-data-education-teacherscollegex-bde1x"));
        resource_list.add(new ResourceItem("Data", "https://www.edx.org/course/explore-statistics-r-kix-kiexplorx-0"));
        resource_list.add(new ResourceItem("ios", "https://itunes.apple.com/itunes-u/developing-apps-for-ios-sd/id395631522"));
        resource_list.add(new ResourceItem("ios", "https://itunes.apple.com/us/course/developing-ios-7-apps-for/id733644550"));
        resource_list.add(new ResourceItem("ios", "https://flatironschool.com/campuses/online/"));
        resource_list.add(new ResourceItem("IOT", "https://iot.eclipse.org/getting-started/"));
        resource_list.add(new ResourceItem("IOT", "https://www.youtube.com/watch?v=UrwbeOIlc68" ));
        resource_list.add(new ResourceItem("IOT", "https://www.edx.org/learn/iot-internet-things"));


        ResourceAdapter r_adapter = new ResourceAdapter(getActivity(),R.layout.resource_item, resource_list);
        final ListView listView = (ListView)resource_view.findViewById(R.id.list);
        listView.setAdapter(r_adapter);

        //on click listener for the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

             ResourceItem currentItem = (ResourceItem) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(currentItem.getLink()));
            startActivity(intent);
          }
        });

        return resource_view;
    }



}
