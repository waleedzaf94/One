package com.clarity.one.model.geocode;

import java.util.ArrayList;
import java.util.List;

public class AddressComponent {

	private String long_name;
	private String short_name;
	private List<String> types = new ArrayList<>();
	
	public String getLongName(){
		return long_name;
	}
	
	public void setLongName(String l){
		this.long_name = l;
	}
	
	public String getShortName(){
		return short_name;
	}
	
	public void setShortName(String s){
		this.short_name = s;
	}
	
	public List<String> getTypes(){
		return types;
	}
	
	public void setTypes(List<String> s){
		this.types = s;
	}
	
	
}
