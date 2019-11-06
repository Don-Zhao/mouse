package com.mouse;

import com.mouse.contract.MyClient;
import com.mouse.contract.MyContract;

import feign.Feign;

public class MyContractApplication {
	public static void main(String[] args) {
		hello();
	}
	
	public static void hello() {
		MyClient myclient = Feign.builder().contract(new MyContract())
			.target(MyClient.class, "http://localhost:8080");
		String result = myclient.hello();
		System.out.println(result);
	}
}
