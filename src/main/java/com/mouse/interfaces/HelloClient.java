package com.mouse.interfaces;

import com.mouse.model.Result;
import com.mouse.model.User;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface HelloClient {
	
	@RequestLine("GET /hello")
	public String hello();
	
	@RequestLine("GET /find/{id}")
	public User find(@Param("id") int id);
	
	@RequestLine("POST /user/create")
	@Headers("Content-Type: application/json")
	public String create(User user);
	
	@RequestLine("POST /user/createXml")
	@Headers("Content-Type: application/xml")
	public Result createXml(User user);
}
