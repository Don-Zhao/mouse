package com.mouse;

import com.mouse.client.MyClient;
import com.mouse.interfaces.HelloClient;
import com.mouse.model.User;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

public class MouseApplication {

	public static void main(String[] args) {
//		pureFeignUser();
//		pureFeignString();
//		useJson();
//		useXml();
		useMyClient();
	}
	
	public static void pureFeignUser() {
//		HelloClient client = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class, 
//				"http://localhost:8080");
//		User user = client.find(5);
//		System.out.println(user.getId());
//		System.out.println(user.getName());
//		System.out.println(user.getUrl());
		
	}
	
	public static void pureFeignString() {
		HelloClient client = Feign.builder().target(HelloClient.class, 
				"http://localhost:8080");
		String result = client.hello();
		System.out.println(result);
	}
	
	public static void useJson() {
		HelloClient client = Feign.builder().encoder(new GsonEncoder())
				.target(HelloClient.class, "http://localhost:8080");
		User user = new User(55, "zhou.shan");
		user.setUrl("http://localhost:8080/user/create");
		System.out.println(client.create(user));
	}
	
	public static void useXml() {
		JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder().build();
		HelloClient client = Feign.builder().encoder(new JAXBEncoder(jaxbFactory))
				.decoder(new JAXBDecoder(jaxbFactory))
				.target(HelloClient.class, "http://localhost:8080");
		User user = new User();
		user.setId(65);
		user.setName("wang.qian");
		user.setUrl("http://localhost:8080/user/createXml");
		System.out.println(client.createXml(user).getMessage());
	}
	
	public static void useMyClient() {
		HelloClient client = Feign.builder()
				.client(new MyClient())
				.target(HelloClient.class, 
				"http://localhost:8080");
		String result = client.hello();
		System.out.println(result);
	}

}
