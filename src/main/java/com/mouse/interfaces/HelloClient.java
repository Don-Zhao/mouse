package com.mouse.interfaces;

import com.mouse.model.User;

import feign.Param;
import feign.RequestLine;

public interface HelloClient {
	
	@RequestLine("GET /hello")
	public String hello();
	
	@RequestLine("GET /find/{id}")
	public User find(@Param("id") int id);
}
