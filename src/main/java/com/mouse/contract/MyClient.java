package com.mouse.contract;

import com.mouse.model.User;

import feign.Request.HttpMethod;

public interface MyClient {
	
	@MyUrl(url="/hello", method=HttpMethod.GET)
	public String hello();
	
	@MyUrl(url="/user/create", method=HttpMethod.POST)
	public String createUser(User user);
}
