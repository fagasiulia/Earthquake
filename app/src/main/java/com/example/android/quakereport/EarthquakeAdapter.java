package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.DecimalFormat;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    // Returns a list of view that displays information about the earthquakes
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView with view ID magnitude
        TextView magnitudeView = listItemView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        // Find the TextView with view ID location_offset and the TextView with ID primary_location
        TextView locationOffsetView = listItemView.findViewById(R.id.location_offset);
        TextView primaryLocationView = listItemView.findViewById(R.id.primary_location);
        // Get the full location of the earthquake
        String fullLocation = currentEarthquake.getLocation();
        if(fullLocation.contains(LOCATION_SEPARATOR)){
            String[] locationSplit = fullLocation.split(LOCATION_SEPARATOR);
            // Display the location offset of the current earthquake in location_offset TextView
            locationOffsetView.setText(locationSplit[0] + LOCATION_SEPARATOR);
            // Display the primary location of the current earthquake in primary_location TextView
            primaryLocationView.setText(locationSplit[0]);
        }
        else{
            // Display the location offset of the current earthquake in location_offset TextView
            locationOffsetView.setText(R.string.near_the);
            // Display the primary location of the current earthquake in primary_location TextView
            primaryLocationView.setText(fullLocation);
        }

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    // Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    // Return the formatted date string (i.e. "4:30 PM") from a Date object.
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    
    // Return the formatted magnitude string showing 1 decimal place
   private String formatMagnitude (double magnitude){
       DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
       return magnitudeFormat.format(magnitude);
   }

}
