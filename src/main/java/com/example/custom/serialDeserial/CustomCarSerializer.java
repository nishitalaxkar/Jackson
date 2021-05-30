package com.example.custom.serialDeserial;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomCarSerializer extends StdSerializer<Car> {
	
	public CustomCarSerializer()
	{
		this(null);
		
	}

	 public CustomCarSerializer(Class<Car> t) {
	        super(t);
	    }

		@Override
		public void serialize(Car value, JsonGenerator gen, SerializerProvider provider) throws IOException {
			// TODO Auto-generated method stub
			 gen.writeStartObject();
		        gen.writeStringField("car_brand", value.getType());
		        gen.writeEndObject();
			
		}
}
