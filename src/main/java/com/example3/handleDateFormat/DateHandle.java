package com.example3.handleDateFormat;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.custom.serialDeserial.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DateHandle {

	
	public static void main(String args[]) throws JsonProcessingException
	{ObjectMapper objectMapper = new ObjectMapper();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
	//we can set any date format like  new SimpleDateFormat("yyyy-MM-dd");
	objectMapper.setDateFormat(df);
	 Car car=new Car("yellow","bmw");
	 Date d1=new Date();
	 Request request=new Request(car,d1);
	String carAsString = objectMapper.writeValueAsString(request);
	// output: {"car":{"color":"yellow","type":"renault"},"datePurchased":"2016-07-03 11:43 AM CEST"}
	System.out.println(carAsString);
		
	}
}
