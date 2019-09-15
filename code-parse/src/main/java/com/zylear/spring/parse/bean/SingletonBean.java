package com.zylear.spring.parse.bean;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
