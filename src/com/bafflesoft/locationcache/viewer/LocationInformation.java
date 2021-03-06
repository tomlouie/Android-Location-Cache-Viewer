package com.bafflesoft.locationcache.viewer;

import java.util.Date;

import com.google.android.maps.GeoPoint;

public class LocationInformation implements Comparable<LocationInformation> {
	public String key;
	public int    accuracy;
	public int    confidence;
	public int    latIE6;
	public int    lonIE6;
	public long   timestamp;
	public String type;
	
	public GeoPoint getGeoPoint()
	{
		if ( latIE6 == 0 && lonIE6 == 0 ) return null;
		return new GeoPoint(latIE6, lonIE6);
	}
	
	public String getTimeString()
	{
		return new Date(timestamp).toLocaleString();				
	}
	
	public String toString()
	{
		return "LocationInformation{ key: " + key + " accuracy: " + accuracy + " confidence: " + confidence + " latitude: " + latIE6 + " longitude: " + lonIE6 + " time: " + getTimeString() + "}";		
	}

	@Override
	public int compareTo(LocationInformation another) {
		if ( this.timestamp < another.timestamp ) {
			return -1;
		} else if ( this.timestamp > another.timestamp ) {
			return 1;
		} else {
			return 0;
		}
	}
}
