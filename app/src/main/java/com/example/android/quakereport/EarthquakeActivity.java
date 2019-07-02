
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
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Create a new adapter that takes as parameter the list of the earthquakes;
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);

        // Find the reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);
    }
}
