package com.cognixia.jump.javafinalproject.dao;

public class Address {
	
	//insert into address(address_id, address1, address2, city, state, country, zip_code)

	//every time you add ask the address of the employee or Department update the address
	//table and grab auto increased id and assign it to adressid in the employee and 
	//department table 
	
	
	
	
	private long addressId; 
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	public Address(long addressId, String address1, String address2, String city, String state, String country,
			String zipcode) {
		super();
		this.addressId = addressId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	//add address use constructor 
	public Address(String address1, String address2, String city, String state, String country,
			String zipcode) {
		super();
		
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipcode=" + zipcode + "]";
	}
	
	
	
	
	
	
}
