package com.RentMyCar;

import java.sql.Date;

public class CarElement {

	//Attribute eines Eintrages
	private String firstName;
	private String lastName;	
	private String location;
	private String mail;
	private String phonenumber;
	private String brand;
	private String type;
	private String fuel;
	private String description;
	private double price;
	private String base64image;
	private Date created_at;
	
	public CarElement() {
		
	}


	public CarElement(String firstName, String lastName, String location, String mail, String phonenumber, String brand, String type, String fuel,
			String description, double price) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.mail = mail;
		this.phonenumber = phonenumber;
		this.brand = brand;
		this.type = type;
		this.fuel = fuel;
		this.description = description;
		this.price = price;

		//this.picture = picture;
	}


	
	
	public String getBase64image() {
		return base64image;
	}

	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	

}
