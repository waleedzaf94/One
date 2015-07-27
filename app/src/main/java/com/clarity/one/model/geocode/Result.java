package com.clarity.one.model.geocode;

import java.util.ArrayList;
import java.util.List;

public class Result {

	private List<AddressComponent> address_components = new ArrayList<>();
	private String formatted_address;
	private Geometry geometry;
	private String place_id;
	private List<String> types = new ArrayList<>();
	
	public List<AddressComponent> getAddressComponents(){
		return address_components;
	}
	
	public void setAddressComponents(List<AddressComponent> l){
		this.address_components = l;
	}
	
	public String getFormattedAddress(){
		return formatted_address;
	}
	
	public void setFormattedAddress(String a){
		this.formatted_address = a;
	}
	
	public Geometry getGeometry(){
		return geometry;
	}
	
	public void setGeometry(Geometry g){
		this.geometry = g;
	}
	
	public String getPlaceId(){
		return place_id;
	}
	
	public void setPlaceId(String p){
		this.place_id = p;
	}
	
	public List<String> getTypes(){
		return types;
	}
	
	public void setTypes(List<String> t){
		this.types = t;
	}
	
}
