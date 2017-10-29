package codebase.ingatmmanager.model;

import java.util.List;

public class AtmDetailsForCity {

	private String city;
	
	private List<Address> address;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
