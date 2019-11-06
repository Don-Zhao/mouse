package com.mouse;

import com.mouse.contract.MyClient;
import com.mouse.contract.MyContract;
import com.mouse.contract.interceptor.MyInterceptor;
import com.mouse.model.User;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonEncoder;

public class MyClientInterceptor {
	
	public static void main(String[] args) {
		create();
	}
	
	public static void hello() {
		MyClient myclient = Feign.builder()
				//.requestInterceptor(new MyInterceptor())
				.contract(new MyContract())
				.target(MyClient.class, "http://localhost:8080");
		String result = myclient.hello();
		System.out.println(result);
	}
	
	public static void create() {
		MyClient myclient = Feign.builder()
				.logLevel(Logger.Level.FULL)
				.logger(new Logger.JavaLogger().appendToFile("D:\\log\\logs\\mouse\\trace.log"))
				.encoder(new GsonEncoder())
				.requestInterceptor(new MyInterceptor())
				.contract(new MyContract())
				.target(MyClient.class, "http://localhost:8080");
		User user = new User();
		user.setId(66);
		user.setName("zhang.yue");
		user.setUrl("http://localhost:8080/user/create");
		String result = myclient.createUser(user);
		System.out.println(result);
	}
}
