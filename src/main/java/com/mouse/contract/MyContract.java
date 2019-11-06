package com.mouse.contract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import feign.Contract.BaseContract;
import feign.MethodMetadata;
import feign.Request.HttpMethod;

public class MyContract extends BaseContract {

	@Override
	protected void processAnnotationOnClass(MethodMetadata data, Class<?> clz) {

	}

	@Override
	protected void processAnnotationOnMethod(MethodMetadata data, Annotation annotation, Method method) {
		if (MyUrl.class.isAnnotation()) {
			MyUrl myUrl = method.getAnnotation(MyUrl.class);
			String url = myUrl.url();
			HttpMethod urlMethod = myUrl.method();
			
			data.template().method(urlMethod);
			data.template().uri(url);
		}
	}

	@Override
	protected boolean processAnnotationsOnParameter(MethodMetadata data, Annotation[] annotations, int paramIndex) {
		return false;
	}

}
