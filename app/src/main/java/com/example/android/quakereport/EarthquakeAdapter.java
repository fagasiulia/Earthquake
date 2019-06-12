package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    // Returns a list of view that displays information about the earthquakes
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the earthquake at a give position in the earthquakes list
        Earthquake earthquake = getItem(position);

        // Set the first text view to display the magnitude of the earthquake
        TextView magnitude =  listItemView.findViewById(R.id.magnitude_id);
        magnitude.setText(earthquake.getMagnitude());

        // Set the second text view to display the location of the earthquake
        TextView location = listItemView.findViewById(R.id.location_id);
        location.setText(earthquake.getLocation());

        // Set the third text view to display the date of the earthquake
        TextView date = listItemView.findViewById(R.id.date_id);
        date.setText(earthquake.getDate());

        return listItemView;
    }

}
