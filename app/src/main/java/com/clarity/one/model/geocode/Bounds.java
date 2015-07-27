package com.clarity.one.model.geocode;

public class Bounds {

	private Location northeast;
	private Location southwest;
	
	public Location getNortheast(){
		return northeast;
	}
	
	public void setNortheast(Location n){
		this.northeast = n;
	}
	
	public Location getSouthwest(){
		return southwest;
	}
	
	public void setSouthwest(Location s){
		this.southwest = s;
	}
	
}
