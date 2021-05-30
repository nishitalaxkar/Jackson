package com.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		Car car=new Car();
		car.setColor("pink");
		car.setType("BMW");
 
		//SERIALIZING   object to json  A Setter Makes a Non-Public Field Deserializable Only
		mapper.writeValue(new File("C:\\Users\\nishi\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\Jacksonpractice\\target/car.json"),car);
		
		File input=new  File("C:\\Users\\nishi\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\Jacksonpractice\\target/car.json");
		
		//deserialLizing JOSN TO OBJECT A Getter Makes a Non-Public Field Serializable and Deserializable
		Car car1=mapper.readValue(input,Car.class);
		System.out.println(car1);
		
		
//		JSON to Jackson JsonNode
//		Alternatively, a JSON can be parsed into a JsonNode object and used to retrieve data from a specific node:
		String json="{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		JsonNode jsonNode=mapper.readTree(json);
		String color=jsonNode.get("color").asText();
		System.out.println(color);
		
		//Creating a Java List From a JSON Array String
		//We can parse a JSON in the form of an array into a Java object list using a TypeReference:
		File listfile=new File("C:\\Users\\nishi\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\Jacksonpractice\\target/carlist.json");
		List<Car> carlist=mapper.readValue(listfile, new TypeReference<List<Car>>() {});
		System.out.println("List of car"+carlist);
		
		
		
       //Creating Java Map From JSON String
		String jsonString = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Map<String,Object> mapOfStringToObject=mapper.readValue(jsonString, Map.class);
		System.out.println("Map of String Object::"+mapOfStringToObject);
		
		// Configuring Serialization or Deserialization Feature
		//While converting JSON objects to Java classes, in case the JSON string has some new fields, the default process will result in an exception:
		String jsonString2 
		  = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Car car2=mapper.readValue(jsonString2, Car.class);
		System.out.println("the year filed gets ignored when we configure  "+car2);
		
		/**
		 * FAIL_ON_NULL_FOR_PRIMITIVES, which defines if the null values for primitive values are allowed:
		 * objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		 * 
		 * 
		 */
		
		
//		
//		String jsonString3
//		  = "{ \"color\" : \"Black\", \"type\" : null}";
//		ObjectMapper objectMapper=new ObjectMapper();
//		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
//		Car car3=objectMapper.readValue(jsonString3, Car.class);
//		System.out.println(car3);
		
		
		
		
		
	}
}
