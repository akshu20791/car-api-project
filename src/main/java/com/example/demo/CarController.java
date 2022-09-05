package com.example.demo;



import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@RestController
public class CarController {
	 @Autowired
	  private WebClient.Builder webClientBuilder;

	@GetMapping("/cars")
	public Car[] getCars() throws JsonMappingException, JsonProcessingException{
	
		ObjectMapper mapper = new ObjectMapper();
		String list =	webClientBuilder.build()
	                    .get()
	                    .uri("https://car-data.p.rapidapi.com/cars?limit=10&page=0")
	                    .header("x-rapidapi-host", "car-data.p.rapidapi.com")
	    				.header("x-rapidapi-key", "373ee660eamshe299dcf54c1cbe5p10e897jsn1156a70bde93")
	                    .retrieve()
	                    .bodyToMono(String.class)
	                    .block();
		Car[] data = mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).readValue(list,Car[].class);
		   return data;
		   					
		
	 					
	}

}
