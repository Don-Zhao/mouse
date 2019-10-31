package com.mouse;

import com.mouse.interfaces.HelloClient;
import com.mouse.model.User;

import feign.Feign;
import feign.gson.GsonDecoder;

public class MouseApplication {

	public static void main(String[] args) {
		pureFeignUser();
		pureFeignString();
	}
	
	public static void pureFeignUser() {
		HelloClient client = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class, 
				"http://localhost:8080");
		User user = client.find(5);
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getUrl());
		
	}
	
	public static void pureFeignString() {
		HelloClient client = Feign.builder().target(HelloClient.class, 
				"http://localhost:8080");
		String result = client.hello();
		System.out.println(result);
	}

}
