package com.example.custom.serialDeserial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomSerialDeserial {
	
	public static void main(String args[]) throws JsonProcessingException
	{
		
		ObjectMapper objectmapper=new ObjectMapper();
		
		SimpleModule module=new SimpleModule("CustomCarSerializer",new Version(1, 0, 0, null, null, null));
		module.addSerializer(Car.class, new CustomCarSerializer());
		
		objectmapper.registerModule(module);
		Car car=new Car("yellow","BMW");
		
		String carJson=objectmapper.writeValueAsString(car);
		System.out.println(carJson);
	}

}
