package com.mouse.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 利用JAXRS注释来连接restful服务
 * 	使用这个服务，因为不是feign原生的，所以必须有注解翻译器
 * @author zhao.jiahong
 *
 */
public interface RSClient {
	
	@GET
	@Path("/hello")
	public String hello();
}
