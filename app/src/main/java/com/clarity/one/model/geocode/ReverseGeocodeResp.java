package com.clarity.one.model.geocode;

import java.util.ArrayList;
import java.util.List;

public class ReverseGeocodeResp {

	private List<Result> results = new ArrayList<>();
	private String status;
	private String error_message;
	
	public List<Result> getResults(){
		return results;
	}
	
	public void setResults(List<Result> r){
		this.results = r;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String s){
		this.status = s;
	}
	
	public String getErrorMessage(){
		return error_message;
	}
	
	public void setErrorMessage(String e){
		this.error_message = e;
	}
	
}
