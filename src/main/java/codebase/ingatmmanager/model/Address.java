package codebase.ingatmmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
	@JsonProperty("street") 
	private String street;
	@JsonProperty("housenumber") 
	private String housenumber;
	@JsonProperty("postalcode") 
	private String postalcode;
	@JsonProperty("city") 
	private String city;
	@JsonProperty("geoLocation") 
	private GeoLocation geoLocation;
	
	public Address(){
		
	}
	public Address(String street,String housenumber,String postalcode,String city,GeoLocation geoLocation){
		this.street=street;
	    this.housenumber=housenumber;
	    this.postalcode=postalcode;
	    this.city=city;
	    this.geoLocation=geoLocation;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	
}
