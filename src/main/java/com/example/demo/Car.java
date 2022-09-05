package com.example.demo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Car {
	private int id;
	private int year;
	private String make;
	private String model;
	private String type;
	public Car() {
		super();
	}
	public Car(int id, int year, String make, String model, String type) {
		super();
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + ", type=" + type + "]";
	}
	

}
