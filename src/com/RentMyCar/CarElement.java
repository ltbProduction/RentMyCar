package com.RentMyCar;

import java.sql.Blob;
import java.sql.Date;

public class CarElement {

	//Attribute eines Eintrages
	private int element_id;
	private String name;
	private String ort;
	private String mail;
	private String phonenumber;
	private String brand;
	private String type;
	private String fuel;
	private String description;
	private double price;
	private String image;
	
	
	
	public CarElement(int element_id, String name, String ort, String mail, String phonenumber, String brand, String type, String fuel,
			String description, double price) {
		this.element_id = element_id;
		this.name = name;
		this.ort = ort;
		this.mail = mail;
		this.phonenumber = phonenumber;
		this.brand = brand;
		this.type = type;
		this.fuel = fuel;
		this.description = description;
		this.price = price;

		//this.picture = picture;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
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
	public String getImage() {
		return image;
	}
	public void setImage(String picture) {
		this.image = picture;
	}
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getElement_id() {
		return element_id;
	}

	public void setElement_id(int element_id) {
		this.element_id = element_id;
	}
	private Date created_at;

}
