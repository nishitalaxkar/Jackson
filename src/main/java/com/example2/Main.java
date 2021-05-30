package com.example2;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
public static void main(String args[]) throws JsonMappingException, JsonProcessingException
{
 
ObjectMapper mapp=new ObjectMapper();
String jsondata="{ \"name\":\"David\", \"role\": \"Manager\", \"city\": \"Los Angeles\"}";


Map<String,Object> ResultMap=mapp.readValue(jsondata, Map.class);
System.out.println(ResultMap);
	
}

}
