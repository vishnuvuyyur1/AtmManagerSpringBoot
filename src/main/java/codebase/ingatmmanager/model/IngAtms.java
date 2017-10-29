package codebase.ingatmmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IngAtms {
	
	@JsonProperty("address") 
	private Address address;
	@JsonProperty("distance") 
	private int distance;
	@JsonProperty("type") 
	private String type;
	
	public IngAtms(){
		
	}
	public IngAtms(Address address,int distance,String type){
		this.address =address;
		this.distance =distance;
		this.type =type;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
