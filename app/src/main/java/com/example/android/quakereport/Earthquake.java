package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private long mTimeInMilliseconds;
    private  String url;

    public Earthquake(double magnitude, String location, long mTimeInMilliseconds, String url){
        this.magnitude = magnitude;
        this.location = location;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {
        return url;
    }
}
