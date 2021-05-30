package com.example3.handleDateFormat;

import java.util.Date;

import com.example.custom.serialDeserial.Car;

public class Request {
	
	public Car car;
	public Date purchaseDate;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Request(Car car, Date purchaseDate) {
		super();
		this.car = car;
		this.purchaseDate = purchaseDate;
	}
	public Request() {
		super();
	}
	@Override
	public String toString() {
		return "Request [car=" + car + ", purchaseDate=" + purchaseDate + "]";
	}

}
