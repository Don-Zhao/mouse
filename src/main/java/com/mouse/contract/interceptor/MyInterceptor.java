package com.mouse.contract.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		System.out.println("这是自定义的请求拦截器");
		template.header("Content-Type", "application/json");
	}

}
