package com.zylear.spring.parse.mvc.bean;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class TestListBean {

	@PostConstruct
	public void init() {
		System.out.println("TestListBean init");
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
