package com.clarity.one.model.geocode;

public class Geometry {

	private Bounds bounds;
	private Location location;
	private String location_type;
	private Bounds viewport;
	
	public Bounds getBounds(){
		return bounds;
	}
	
	public void setBounds(Bounds b){
		this.bounds = b;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(Location l){
		this.location = l;
	}
	
	public String getLocationType(){
		return location_type;
	}
	
	public void setLocationType(String l){
		this.location_type = l;
	}
	
	public Bounds getViewport(){
		return viewport;
	}
	
	public void setViewport(Bounds v){
		this.viewport = v;
	}
	
}
