package com.zylear.spring.parse.mvc.bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestListBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
