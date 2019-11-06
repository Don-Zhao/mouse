package com.mouse;

import com.mouse.client.RSClient;

import feign.Feign;
import feign.jaxrs.JAXRSContract;

public class RSApplication {
	public static void main(String[] args) {
		hello();
	}
	
	public static void hello() {
		RSClient client = Feign.builder().contract(new JAXRSContract())
			.target(RSClient.class, "http://localhost:8080");
		String result = client.hello();
		System.out.println(result);
	}
}
