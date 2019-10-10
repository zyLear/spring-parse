package com.zylear.spring.parse.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FactoryBeanTest implements FactoryBean<String> {


	public FactoryBeanTest() {
		System.out.println("cons");
	}

	@Override
	public String getObject() throws Exception {
		return "xxx";
	}

	@Override
	public Class<String> getObjectType() {
		return String.class;
	}
}
