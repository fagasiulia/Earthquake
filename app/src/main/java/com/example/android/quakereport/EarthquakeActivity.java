
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a list of some fake earthquakes
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake("4.5", "San Francisco", "Oct 19,2012"));
        earthquakes.add(new Earthquake("5.3", "London", "Mar 10,2013"));
        earthquakes.add(new Earthquake("2.7", "Tokyo", "Feb 21,2015"));
        earthquakes.add(new Earthquake("4.3", "Mexico City", "Oct 19,2012"));
        earthquakes.add(new Earthquake("7.2", "Moscow", "May 3,2015"));
        earthquakes.add(new Earthquake("6.8", "Rio de Janeiro", "Jan 30,2018"));
        earthquakes.add(new Earthquake("5.9", "Paris", "Apr 1, 2016"));

        // Create a new adapter that takes as parameter the list of the earthquakes;
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);

        // Find the reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);
    }
}
